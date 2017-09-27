package JFinal.common;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.jfinal.kit.PathKit;

/**
 * 类扫描器
 * @author taoge
 * @version 1.0
 * @create_at 2017年8月29日下午10:25:56
 */
public class ClassScanner {

	@SuppressWarnings("rawtypes")
	private static final Set<Class> appClasses = new HashSet<Class>();

    public static <T> List<Class<T>> scanSubClass(Class<T> pclazz) {
        return scanSubClass(pclazz, false);
    }

    public static <T> List<Class<T>> scanSubClass(Class<T> pclazz, boolean mustCanNewInstance) {
        if (pclazz == null) {
            throw new RuntimeException("pclazz cannot be null");
        }

        if (appClasses.isEmpty()) {
            initAppClasses();
        }

        List<Class<T>> classes = new ArrayList<Class<T>>();
        findClassesByParent(classes, pclazz, mustCanNewInstance);
        return classes;
    }

    @SuppressWarnings("rawtypes")
	public static List<Class> scanClass() {
        return scanClass(false);
    }

    @SuppressWarnings("rawtypes")
	public static List<Class> scanClass(boolean mustCanNewInstance) {

        if (appClasses.isEmpty()) {
            initAppClasses();
        }

        List<Class> list = new ArrayList<Class>();

        if (mustCanNewInstance) {
            for (Class clazz : appClasses) {
                if (clazz.isInterface()
                        || Modifier.isAbstract(clazz.getModifiers())) {
                    continue;
                }
                list.add(clazz);
            }
        } else {
            list.addAll(appClasses);
        }

        return list;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Class> scanClassByAnnotation(Class annotationClass, boolean mustCanNewInstance) {

        if (appClasses.isEmpty()) {
            initAppClasses();
        }

        List<Class> list = new ArrayList<Class>();

        for (Class clazz : appClasses) {
            Annotation annotation = clazz.getAnnotation(annotationClass);
            if (annotation == null) {
                continue;
            }

            if (mustCanNewInstance) {
                if (clazz.isInterface()
                        || Modifier.isAbstract(clazz.getModifiers())) {
                    continue;
                }
            }

            list.add(clazz);
        }
        return list;
    }


    /**
     * 开发环境下，用于热加载后重新清空所有的类
     */
    static void clearAppClasses() {
        appClasses.clear();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> void findClassesByParent(List<Class<T>> classes, Class<T> pclazz, boolean mustCanNewInstance) {
        for (Class clazz : appClasses) {
            tryToaddClass(classes, pclazz, mustCanNewInstance, clazz);
        }
    }

    private static void initAppClasses() {

        initByFilePath(PathKit.getRootClassPath());

        Set<String> jars = new HashSet<String>();
        findJars(jars, ClassScanner.class.getClassLoader());

        for (String path : jars) {

            JarFile jarFile = null;

            try {
                jarFile = new JarFile(path);
                Enumeration<JarEntry> entries = jarFile.entries();

                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    String entryName = jarEntry.getName();
                    if (!jarEntry.isDirectory() && entryName.endsWith(".class")) {
                        String className = entryName.replace("/", ".").substring(0, entryName.length() - 6);
                        initAppClasses(classForName(className));
                    }
                }
            } catch (IOException e1) {
            } finally {
                if (jarFile != null)
                    try {
                        jarFile.close();
                    } catch (IOException e) {
                    }
            }

        }
    }

    private static void initByFilePath(String filePath) {
        List<File> classFileList = new ArrayList<File>();
        scanClassFile(classFileList, filePath);
        for (File file : classFileList) {

            int start = filePath.length();
            int end = file.toString().length() - ".class".length();

            String classFile = file.toString().substring(start + 1, end);
            initAppClasses(classForName(classFile.replace(File.separator, ".")));
        }
    }

    @SuppressWarnings("rawtypes")
	private static void initAppClasses(Class clazz) {
        if (clazz != null)
            appClasses.add(clazz);
    }


    private static void findJars(Set<String> set, ClassLoader classLoader) {
        try {
            if (classLoader instanceof URLClassLoader) {
                URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
                URL[] urLs = urlClassLoader.getURLs();
                String JAVA_HOME = new File(System.getProperty("java.home"), "..").getCanonicalPath();
                for (URL url : urLs) {
                    String path = url.getPath();

                    // path : /d:/xxx
                    if (path.startsWith("/") && path.indexOf(":") == 2) {
                        path = path.substring(1);
                    }

                    if (!path.toLowerCase().endsWith(".jar")) {
                        initByFilePath(new File(path).getCanonicalPath());
                    }

                    if (!path.startsWith(JAVA_HOME)) {
                        set.add(url.getPath());
                    }
                }
            }
            ClassLoader parent = classLoader.getParent();
            if (parent != null) {
                findJars(set, parent);
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static <T> void tryToaddClass(List<Class<T>> classes, Class<T> pclazz, boolean mustCanNewInstance, Class<T> clazz) {
        if (classes == null
                || pclazz == null
                || clazz == null
                || !pclazz.isAssignableFrom(clazz)) {

            return;
        }

        if (!mustCanNewInstance) {
            classes.add(clazz);
            return;
        }

        if (clazz.isInterface()
                || Modifier.isAbstract(clazz.getModifiers())) {
            return;
        }

        classes.add(clazz);
    }


    @SuppressWarnings({  "rawtypes" })
    private static Class classForName(String className) {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            return Class.forName(className, false, cl);
        } catch (Throwable ex) {
            //ignore
        }
        return null;
    }

    private static void scanClassFile(List<File> fileList, String path) {
        File files[] = new File(path).listFiles();
        if (null == files || files.length == 0)
            return;
        for (File file : files) {
            if (file.isDirectory()) {
                scanClassFile(fileList, file.getAbsolutePath());
            } else if (file.getName().endsWith(".class")) {
                fileList.add(file);
            }
        }
    }
}

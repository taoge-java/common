package jboot;

import javax.servlet.ServletContext;

import com.jboot.config.JfinalBootConfig;
import com.jboot.util.PathKit;

public class JfinalBoot {

	private ServletContext servletContext;
	
	private String contextPath = "";
	
	private static final JfinalBoot jfinalBoot=new JfinalBoot();
	
	public static JfinalBoot me(){
		return jfinalBoot;
	}
	
	private JfinalBoot(){}
	
	public void init(JfinalBootConfig jfinalBootConfig,ServletContext servletContext){
		this.servletContext = servletContext;
		this.contextPath = servletContext.getContextPath();
		
		initPath();
		
		initActionManpping();
		initHandler();
	}
	
	private void initPath() {
		String root = servletContext.getRealPath("/");
		PathKit path = new PathKit();
		path.setWebrootPath(root);
	}

	private void initActionManpping(){
		
	}
	
	private void initHandler(){
		
	}
}

package jboot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jboot.config.JfinalBootConfig;
import com.jboot.constant.Constant;



public class JfinalBootFilter implements Filter{

	private JfinalBootConfig jfinalBootConfig;
	
	private int contextPathLength;
	
	private JfinalBoot jfinalBoot = JfinalBoot.me();
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding(Constant.ENCODING);
		response.setCharacterEncoding(Constant.ENCODING);
		String target = request.getRequestURI();
		if (contextPathLength != 0) {
			target = target.substring(contextPathLength);
		}
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		createConfig(filterConfig.getInitParameter("configClass"));
		jfinalBoot.init(jfinalBootConfig, filterConfig.getServletContext());
		String contextPath = filterConfig.getServletContext().getContextPath();
		contextPathLength= contextPath.length();
	}

	private void createConfig(String configClass){
		if(configClass==null){
			throw new RuntimeException("Please set configClass parameter of JFinalFilter in web.xml");
		}
		Object config=null;
		try {
			config=Class.forName(configClass).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Can not create instance of class: " + configClass, e);
		} 
		if(config instanceof JfinalBootConfig){
			jfinalBootConfig=(JfinalBootConfig)config;
			
		}else{
			throw new RuntimeException("Can not create instance of class: " + configClass + ". Please check the config in web.xml");
		}
	}
}

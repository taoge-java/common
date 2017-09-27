package com.information.common.config;


import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;

import com.jfinal.kit.PropKit;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;


public abstract class CommonConfig extends JFinalConfig{

    public final static String BASE_VIEW="/WEB-INF/views";//页面存放路径
	
	public static String redisHost; // redis主机
	
	public static String channels;//redis订阅频道
	
	public static String redisPassword; // redis密码
	
	public static String resourceUpload;//文件上传路径
	
	public static String resourceDown;
	
	public static String cookie_name;
	
	public static String  weixinToken;
	
	@Override
	public void configConstant(Constants constants) {
		 constants.setDevMode(true);
		 constants.setViewType(ViewType.VELOCITY);
		 constants.setEncoding("utf-8");
		 JFinal.me().getConstants().setError404View(BASE_VIEW+"/common/404.vm");
		 JFinal.me().getConstants().setError500View(BASE_VIEW+"/common/500.vm");
		 PropKit.use("config.properties");//加载配置文件
		 redisPassword = PropKit.get("redis.password").trim();
		 redisHost = PropKit.get("redis.host").trim();
		 channels=PropKit.get("redis.channels").trim();
		 resourceUpload=PropKit.get("resource.upload.path").trim();
		 resourceDown=PropKit.get("resource.upload.path").trim();
		 weixinToken=PropKit.get("weixin.token").trim();
		 cookie_name=PropKit.get("cookie.name").trim();
		 constants.setBaseDownloadPath(resourceUpload);
		 loadConfigConstant(constants);
	}

	@Override
	public void configRoute(Routes routes) {
		loadConfigRoute(routes);
	}

	@Override
	public void configEngine(Engine engine) {
		loadConfigEngine(engine);
	}

	@Override
	public void configPlugin(Plugins plugin) {
	}

	@Override
	public void configInterceptor(Interceptors interceptors) {
		loadConfigInterceptor(interceptors);
		
	}

	@Override
	public void configHandler(Handlers handlers) {
		loadConfigHandler(handlers);
	}
	
	public abstract void loadConfigConstant(Constants constants);
	public abstract void loadConfigRoute(Routes routes);
	public abstract void loadConfigEngine(Engine engine);
	public abstract void loadConfigPlugin(Plugins plugin);
	public abstract void loadConfigInterceptor(Interceptors interceptor);
	public abstract void loadConfigHandler(Handlers handler);
}

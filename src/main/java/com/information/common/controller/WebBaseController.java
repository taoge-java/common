package com.information.common.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.information.common.config.CommonConfig;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
/**
 * 控制器父类
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年4月22日 下午4:43:28
 */
public class WebBaseController extends Controller{
	
	
	public void rendView(String path){
		render(CommonConfig.BASE_VIEW+path);
	}
	
	public <T> T getInstance(Class<T> cls){
		return Duang.duang(cls.getSimpleName(),cls);
	}
	
	/**
	 * 生成新的图片文件
	 * @return
	 */
	public String getImagePath(){
		DateFormat format = new SimpleDateFormat("yyyy-MMdd");
		return format.format(new Date()).replaceAll("-", "/");
	}
	
	/**
	 * 发送站内信
	 * @param userId
	 * @param title
	 * @param content
	 */
	public void sendMessage(int userId,String title,String content){
		
	}
}

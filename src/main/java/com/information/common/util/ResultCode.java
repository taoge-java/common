package com.information.common.util;
/**
 * 为方便处理ajax请求
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年6月28日上午9:28:04
 */
public class ResultCode {
	
	public static final int SUCCESS=1;
	
	public static final int FAIL=0;
	
	public int code=SUCCESS;
	
	public String message="";

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
		System.out.println("MESSAGE:"+message);
	}

	public ResultCode(int code) {
		this.code=code;
	}
}

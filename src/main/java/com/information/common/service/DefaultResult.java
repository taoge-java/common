package com.information.common.service;

import java.util.HashMap;
import java.util.Map;

import com.information.common.util.ResultCode;

/**
 * 返回结果接口实现类
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年6月13日 下午9:36:35
 */
public class DefaultResult implements Result{
	
    private Map<String,Object> map=new HashMap<String, Object>();
	
	private boolean success=true;
	
	private ResultCode resultCode;
	
    public DefaultResult(){
		
	}
	
	public DefaultResult(boolean success){
		if(success){
			this.resultCode=new ResultCode(ResultCode.SUCCESS);
		}else{
			this.resultCode=new ResultCode(ResultCode.FAIL);
		}
	}

	public DefaultResult(ResultCode resultCode){
    	this.resultCode=resultCode;
    	if(resultCode.code==ResultCode.SUCCESS){
			success=true;
		}else{
			success=false;
		}
    }
	
	public boolean isSuccess() {
		return success;
	}

	public void setModel(String key, Object value) {
		map.put(key, value);
	}

	public void setDefaultModel(Object model) {
		map.put(DEFAULT_MODEL_KEY, model);
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode=resultCode;
		if(resultCode.code==ResultCode.SUCCESS){
			success=true;
		}else{
			success=false;
		}
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public Map<String, Object> getModels() {
		return map;
	}

	public Object getDefaultModel() {
		return map.get(DEFAULT_MODEL_KEY);
	}
}

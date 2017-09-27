package jboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {

    private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	public void init(HttpServletRequest request,HttpServletResponse response){
		this.request=request;
		this.response=response;
	}
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getPara(String name){
		return request.getParameter(name);
	}
	
	
	public void render(String view){
		
	}
}

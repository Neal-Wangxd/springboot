package com.microboot.bean; 
/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月12日 下午2:53:57 
* 类说明 : 错误信息类
*/
public class ErrorInfo {
	
	private Integer code;
	private String message;
	private String url;
	
	
	public ErrorInfo(){
		
	}
	
	
	public ErrorInfo(Integer code, String message, String url) {
		super();
		this.code = code;
		this.message = message;
		this.url = url;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ErrorInfo [code=" + code + ", message=" + message + ", url=" + url + "]";
	}
	

}
 
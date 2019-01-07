package com.volley.utility;

import java.io.Serializable;

public class JsonResult implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private String serviceName;
	private String contentType;
	private Object data;
	private int rc;

	public JsonResult() {

	}

	public JsonResult(String serviceName, String contentType) {
		this.serviceName = serviceName;
		this.contentType = contentType;
	}
		public JsonResult(String serviceName, String contentType, int rc) {
		this.serviceName = serviceName;
		this.contentType = contentType;
		this.rc = rc;
	}
		
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

}
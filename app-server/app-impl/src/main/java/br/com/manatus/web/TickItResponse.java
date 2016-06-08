package br.com.manatus.web;

import java.io.Serializable;

public class TickItResponse implements Serializable{
	
	private static final long serialVersionUID = -6915506512815158566L;

	String msg;
	String status;
	Object obj;
	
	private TickItResponse(String msg, String status) {
		this.msg = msg;
		this.status = status;
		this.obj = null;
	}
	
	private TickItResponse(String msg, String status, Object obj) {
		this.msg = msg;
		this.status = status;
		this.obj = obj;
	}
	
	public static TickItResponse ok() {
		return new TickItResponse("Ok", "success");
	}
	
	public static TickItResponse ok(String msg, Object obj) {
		return new TickItResponse(msg, "success", obj);
	}
	
	public static TickItResponse ok(Object obj) {
		return new TickItResponse("Ok", "success", obj);
	}
	
	public static TickItResponse error(String msg) {
		return new TickItResponse(msg, "error");
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
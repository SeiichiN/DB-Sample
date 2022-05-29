package model.bean;

import java.io.Serializable;

public class State implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sid;
	private String sname;
	
	public State() {}
	public State(String sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}

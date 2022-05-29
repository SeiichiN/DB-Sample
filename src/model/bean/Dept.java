package model.bean;

import java.io.Serializable;

public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String did;
	private String dname;
	
	public Dept () {}
	public Dept (String did, String dname) {
		this.did = did;
		this.dname = dname;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
}


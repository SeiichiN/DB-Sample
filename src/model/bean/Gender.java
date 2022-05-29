package model.bean;

import java.io.Serializable;

public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String gid;
	private String gname;
	
	public Gender() {}
	public Gender(String gid, String gname) {
		this.gid = gid;
		this.gname = gname;
	}

	public String getGid() {
		return gid;
	}
	public String getGname() {
		return gname;
	}
}

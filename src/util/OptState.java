package util;

import java.io.Serializable;

public class OptState implements Serializable {
	private static final long serialVersionUID = 1L;
	private String no;
	private String name;
	
	public OptState() {}
	public OptState(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

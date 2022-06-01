package model.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String pass;
	private String name;
	private Gender gender;
	private String birthday;
	private State state;
	private Dept dept;
	
	public Employee () {}
	public Employee(int id, String pass, String name, Gender gender, 
			         String birthday, State state, Dept dept) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.state = state;
		this.dept = dept;
	}
	public String toString() {
		return id + " : " + pass + " : " + name
				+ " : " + gender.getGname()
				+ " : " + birthday
				+ " : " + state.getSname()
				+ " : " + dept.getDname();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}

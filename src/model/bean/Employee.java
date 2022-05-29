package model.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String pass;
	private String name;
	private Gender gender;
	private int age;
	private State state;
	private Dept dept;
	
	public Employee () {}
	public Employee(int id, String pass, String name, Gender gender, 
			         int age, State state, Dept dept) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.state = state;
		this.dept = dept;
	}
	public String toString() {
		return id + " : " + pass + " : " + name
				+ " : " + gender.getGname()
				+ " : " + age
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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

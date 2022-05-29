package model.bean;

import java.io.Serializable;

public class PageInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int perPage = 5;
	private int dataMax;
	private int current = 1;
	private int skip = 0;
	private int first = 1;
	private int last = 1;
	
	public PageInfo () {}
	public PageInfo (int dataMax) {
		this.dataMax = dataMax;
		setLast();
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
		setLast();
	}
	public int getDataMax() {
		return dataMax;
	}
	public void setDataMax(int dataMax) {
		this.dataMax = dataMax;
		setLast();
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast() {
		this.last = (int) Math.ceil((double) this.dataMax / (double) this.perPage);
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
		this.skip = (current - 1) * perPage;
	}
	public int getSkip() {
		return skip;
	}
	
}

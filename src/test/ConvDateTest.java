package test;

import java.sql.Date;

import util.Tool;

public class ConvDateTest {

	public static void main(String[] args) {
		String txt = "2022/04\05";
		Date date = Tool.convDate(txt);
		System.out.println(date);
	}

}

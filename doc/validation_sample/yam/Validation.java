package jp.co.sss.crud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Validation {

	//ログインに関する入力チェック
	public static List<String> isLogin(String id, String password){
		List<String>errorMessages = new ArrayList<>();
		//IDに関するチェック
		if(id == "") {
			errorMessages.add(Messages.requiredMessage("社員ID"));
		}else {
			if(!checkChangeInteger(id)) {
				errorMessages.add(Messages.requiredIntegerMessage("社員ID"));
			}else if(!checkHalfWidth(id)){
				errorMessages.add(Messages.requiredHalfWidth("社員ID"));
			}else if (!checkIntegerLength(id, 99999)){
				errorMessages.add(Messages.illigalIntegerLengthMessage("社員ID", 99999));
			}
		}

		//PASSWORDに関する入力チェック
		if(password == "") {
			errorMessages.add(Messages.requiredMessage("パスワード"));
		}else if(!checkHalfWidth(password)){
			errorMessages.add(Messages.requiredHalfWidth("パスワード"));
		}else if(!checkStringLength(password, 16)) {
			errorMessages.add(Messages.illigalStringLengthMessage("パスワード", 16));
		}
		return errorMessages;
	}
	//登録更新に関する入力チェック
	public static List<String> isUpdate(HttpServletRequest request) {

		List<String>errorMessages = new ArrayList<String>();

		String servletPath = request.getServletPath();

		//登録・更新処理のみ入力値の判定を行う
		if(servletPath.contains("/Update") || servletPath.contains("/Regist")) {

			String password = request.getParameter("empPass");
			String name = request.getParameter("empName");
			String address = request.getParameter("address");
			String date = request.getParameter("birthday");

			//PASSWORDに関する入力チェック
			if(password == "") {
				errorMessages.add(Messages.requiredMessage("パスワード"));
			}else if(!checkHalfWidth(password)){
				errorMessages.add(Messages.requiredHalfWidth("パスワード"));
			}else if(!checkStringLength(password, 16)) {
				errorMessages.add(Messages.illigalStringLengthMessage("パスワード", 16));
			}

			//社員名に関する入力チェック
			if(name == "") {
				errorMessages.add(Messages.requiredMessage("社員名"));
			}else if(!checkStringLength(name, 30)) {
				errorMessages.add(Messages.illigalStringLengthMessage("社員名", 30));
			}

			//住所に関する入力チェック
			if(address == "") {
				errorMessages.add(Messages.requiredMessage("住所"));
			}else if(!checkStringLength(address, 60)) {
				errorMessages.add(Messages.illigalStringLengthMessage("住所", 60));
			}

			//日付に関する入力チェック
			if(date == "") {
				errorMessages.add(Messages.requiredMessage("日付"));
			}else if(!checkDate(date)) {
				errorMessages.add(Messages.ILLIGAL_DATE_MESSAGE);
			}
		}
		return errorMessages;
	}

	//半角英数字判定を行うメソッド
	private static boolean checkHalfWidth(String params) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher matcher = pattern.matcher(params);
        return matcher.find();
	}


	//入力値(文字列)の長さに関して判定を行うメソッド
	private static boolean checkStringLength(String params, int max) {
		if(max < params.length()) {
			return false;
		}else {
			return true;
		}
	}
	//入力値(数値)の長さに関して判定を行うメソッド
	private static boolean checkIntegerLength(String params, int max) {
		if(max < Integer.parseInt(params)) {
			return false;
		}else {
			return true;
		}
	}
	//入力値が数値であるか判定するメソッド
	private static boolean checkChangeInteger(String params) {
		try {
			Integer.parseInt(params);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	//入力値の日付が正しいかどうか判定するメソッド
	private static boolean checkDate(String params) {
		try{
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		    sdf.setLenient(false);
		    sdf.parse(params);
		    return true;
		}catch(ParseException e){
		    return false;
		}
	}
}


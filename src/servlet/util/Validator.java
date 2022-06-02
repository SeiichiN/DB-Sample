package servlet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.FindDeptByIdLogic;
import model.FindGenderByIdLogic;
import model.FindStateByIdLogic;
import model.bean.Dept;
import model.bean.Employee;
import model.bean.Gender;
import model.bean.State;
import util.Const;
import util.Messages;
import util.Tool;

public class Validator {
	/**
	 * request から、parameterを取得し、チェックをする。
	 * もし、不適合なら、errorMsgListにメッセージを入れる。
	 * @param employee 空のEmployee
	 * @param request ユーザーの入力したもの
	 * @return エラーメッセージリスト
	 */
	public List<String> inputCheck(Employee employee, HttpServletRequest request) {
		List<String> errorMsgList = new ArrayList<>();
		
		String id = request.getParameter("id");
		if (inputIdCheck(id, errorMsgList)) {
			employee.setId(Tool.myParseInt(id, 0));
		}
		
		String name = request.getParameter("name");
		if (inputNameCheck(name, errorMsgList)) {
			employee.setName(name);
		}
		String pass = request.getParameter("pass");
		if (inputPassCheck(pass, errorMsgList)) {
			employee.setPass(pass);
		}
		String gid = request.getParameter("gender");
		if (inputGenderCheck(gid, errorMsgList)) {
			Gender gender = new Gender();
			gender.setGid(gid);
			FindGenderByIdLogic logic = new FindGenderByIdLogic();
			logic.execute(gender);
			employee.setGender(gender);
		}
		String birthday = request.getParameter("birthday");
		if (inputDateCheck(birthday, errorMsgList)) {
			employee.setBirthday(birthday);
		}
		String sid = request.getParameter("state");
		if (inputStateCheck(sid, errorMsgList)) {
			State state = new State();
			state.setSid(sid);
			FindStateByIdLogic logic = new FindStateByIdLogic();
			logic.execute(state);
			employee.setState(state);
		}
		String did = request.getParameter("dept");
		if (inputDeptCheck(did, errorMsgList)) {
			Dept dept = new Dept();
			dept.setDid(did);
			FindDeptByIdLogic logic = new FindDeptByIdLogic();
			logic.execute(dept);
			employee.setDept(dept);
		}
		
		return errorMsgList;
	}

	private boolean inputIdCheck(String id, List<String> errorMsgList) {
		boolean result = true;
		if (isNull(id)) {
			result = false;
		}
		return result;
	}
	private boolean inputNameCheck(String name, List<String> errorMsgList) {
		boolean result = true;
		if (isNull(name)) {
			errorMsgList.add(Messages.ERROR_INPUT_NAME);
			result = false;
		}
		if (isOverLength(name, Const.INPUT_NAME_LENGTH)) {
			errorMsgList.add(Messages.ERROR_NAME_LENGTH);
			result = false;
		}
		return result;
	}

	private boolean inputPassCheck(String pass, List<String> errorMsgList) {
		boolean result = true;
		if (isNull(pass)) {
			errorMsgList.add(Messages.ERROR_INPUT_PASS);
			result = false;
		} else {
			if (isOverLength(pass, Const.INPUT_PASS_LENGTH)) {
				errorMsgList.add(Messages.ERROR_PASS_LENGTH);
				result = false;
			}
			if (! Tool.isMatch(pass, Const.PREG_PASS)) {
				errorMsgList.add(Messages.ERROR_INPUT_MATCH);
				result = false;
			}
		}
		return result;
	}

	private boolean inputGenderCheck(String gid, List<String> errorMsgList) {
		boolean result = true;
		if (isNull(gid)) {
			errorMsgList.add(Messages.ERROR_INPUT_GENDER);
			result = false;
		}
		if (! isInRange(gid, 1, 3)) {
			errorMsgList.add(Messages.ERROR_GENDER_RANGE);
			result = false;
		}
		return result;
	}

	private boolean inputDateCheck(String date, List<String> errorMsgList) {
		boolean result = true;
		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_FORMAT);
	    sdf.setLenient(false);             // 日付チェックを厳密にする
		try{
		    sdf.parse(date);
		    result = true;
		}catch(ParseException e){
			errorMsgList.add(Messages.ERROR_DATE_FORMAT);
		    result = false;
		}		
		
		return result;
	}
	
	private boolean inputStateCheck(String sid, List<String> errorMsgList) {
		boolean result = true;
		if (isNull(sid)) {
			errorMsgList.add(Messages.ERROR_INPUT_STATE);
			result = false;
		}
		if (! isInRange(sid, 1, 47)) {
			errorMsgList.add(Messages.ERROR_STATE_RANGE);
			result = false;
		}
		return result;
	}
	
	private boolean inputDeptCheck(String did, List<String> errorMsgList) {
		boolean result = true;
		if (isNull(did)) {
			errorMsgList.add(Messages.ERROR_INPUT_DEPT);
			result = false;
		} else {
			if (! Tool.isMatch(did, Const.PREG_DEPT)) {
				errorMsgList.add(Messages.ERROR_DEPT_MATCHES);
				result = false;
			}
		}
		return result;
	}
	
	public boolean isNull(String value) {
		if (value == null || value.length() == 0) {
			return true;
		}
		return false;
	}

	public boolean isOverLength(String value, int length) {
		if (value.length() > length) {
			return true;
		}
		return false;
	}

	public boolean isInRange(String _value, int first, int last) {
		int value = -1;
		try {
			value = Integer.parseInt(_value);
		} catch (NumberFormatException e) {
			value = -1;
		}
		if (value >= first && value <= last) {
			return true;
		}
		return false;
	}
	
}

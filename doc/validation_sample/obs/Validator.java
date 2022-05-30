package jp.co.sss.crud.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.bean.Employee;

/**
 * エラーに関する処理をまとめたクラス
 *
 * @author SystemShared
 *
 */
public class Validator {

	/** インスタンス化を禁止 */
	private Validator() {
	}

	/**
	 * 未入力のチェックを行うメソッド
	 *
	 * @param val
	 * @return true(空)
	 *         false(空でない)
	 */
	public static boolean isEmpty(String val) {
		if (val == null || val.isEmpty()) {
			return true;
		} else  {
			return false;
		}
	}

	/**
	 * 数値かどうかのチェックを行うメソッド
	 *
	 * @param val
	 * @return true(数値)
	 *         false(数値でない)
	 */
	public static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 指定した桁数を超えているかチェックを行うメソッド
	 *
	 * @param val
	 *        digit
	 * @return true(桁数を超えている)
	 *         false(桁数を超えていない)
	 */
	public static boolean overLength(String val, int digit) {
		if (val.length() > digit) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 日付の妥当性チェック
	 *
	 * @param val
	 * @return true(正しい日付)
	 *         false(誤った日付)
	 */
	public static boolean isDate(String val) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			format.setLenient(false);
			format.parse(val);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * ログイン画面に表示するエラーメッセージのリストを作成するメソッド
	 *
	 * @param id
	 *        password
	 * @return エラーメッセージのリスト
	 */
	public static List<String> makeLoginErrorMessageList(String id, String password) {
		List<String> errorMessageList = new ArrayList<String>();

		// ****** idのチェック ******
		// 未入力チェック
		if (isEmpty(id)) {
			errorMessageList.add(Constants.EMPID_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(id, 5)) {
				errorMessageList.add(Constants.EMPID_LENGTH_OVER);
			// 数値チェック
			} else if (!isNumber(id)) {
				errorMessageList.add(Constants.EMPID_MISSMATCH);
			}
		}

		// ****** パスワードのチェック ******
		// 未入力チェック
		if (isEmpty(password)) {
			errorMessageList.add(Constants.PASSWORD_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(password, 16)) {
				errorMessageList.add(Constants.PASSWORD_LENGTH_OVER);
			}
		}

		return errorMessageList;
	}

	/**
	 * 登録(更新)入力画面に表示するエラーメッセージのリストを作成するメソッド
	 *
	 * @param employeeBean
	 * @return エラーメッセージのリスト
	 */
	public static List<String> makeInputErrorMessageList(Employee employeeBean) {
		List<String> errorMessageList = new ArrayList<String>();

		// ****** パスワードのチェック ******
		// 未入力チェック
		if (isEmpty(employeeBean.getEmpPass())) {
			errorMessageList.add(Constants.PASSWORD_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(employeeBean.getEmpPass(), 16)) {
				errorMessageList.add(Constants.PASSWORD_LENGTH_OVER);
			}
		}

		// ****** 社員名のチェック ******
		// 未入力チェック
		if (isEmpty(employeeBean.getEmpName())) {
			errorMessageList.add(Constants.NAME_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(employeeBean.getEmpName(), 30)) {
				errorMessageList.add(Constants.NAME_LENGTH_OVER);
			}
		}

		// ****** 住所のチェック ******
		// 未入力チェック
		if (isEmpty(employeeBean.getAddress())) {
			errorMessageList.add(Constants.ADDRESS_EMPTY);
		} else {
			// 桁数チェック
			if (overLength(employeeBean.getAddress(), 60)) {
				errorMessageList.add(Constants.ADDRESS_LENGTH_OVER);
			}
		}

		// ****** 生年月日のチェック ******
		// 未入力チェック
		if (isEmpty(employeeBean.getBirthday())) {
			errorMessageList.add(Constants.BIRTHDAY_EMPTY);
		} else {
			// 日付の妥当性チェック
			if (!isDate(employeeBean.getBirthday())) {
				errorMessageList.add(Constants.BIRTHDAY_MISSMATCH);
			}
		}

		return errorMessageList;
	}
}
package util;

import java.util.ArrayList;
import java.util.List;

public class Validator {
	public List<String> inputCheck() {
		List<String> errorMsgList = new ArrayList<>();
		
		if (! isNotNull()) {
			errorMsg = "なにか入力してください。";
		}
		
		return errorMsgList;
	}
	
	public boolean isNotNull(String value) {
		if (value == null || value.length() < 1) {
			return false;
		}
		return true;
	}
}

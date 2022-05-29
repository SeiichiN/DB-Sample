package util;

public class Tool {
	/**
	 * 引数 _value の文字(数値) を int にする。
	 * もしも エラーが起こったら、def にする。
	 * @param _value:String 数値にしたい文字列
	 * @param def:int デフォルト値
	 * @return value:int
	 */
	public static int myParseInt(String _value, int def) {
		int value = 0;
		try {
			value = Integer.parseInt(_value);
		} catch (NumberFormatException e) {
			value = def;
		}
		return value;
	}

}

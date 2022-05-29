package exception;

public class SQLRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SQLRuntimeException() {
		super("データベース接続エラー");
	}
	
	public SQLRuntimeException(String msg) {
		super(msg);
	}
}

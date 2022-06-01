package exception;

public class NotEmptyRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotEmptyRuntimeException() {
		super("そのオブジェクトは空ではありません。");
	}
	
	public NotEmptyRuntimeException(String obj_name) {
		super(obj_name +" は空ではありません。");
	}
	
}

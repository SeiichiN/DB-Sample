package exception;

public class NotEmptyRuntimeException extends RuntimeException {
	public NotEmptyRuntimeException() {
		super("そのオブジェクトは空ではありません。");
	}
	
	public NotEmptyRuntimeException(String obj_name) {
		super(obj_name +" は空ではありません。");
	}
	
}

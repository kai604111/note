package cn.tedu.note.exception;

public class NameOrPasswordException extends RuntimeException {

	private static final long serialVersionUID = 155009611367285562L;
	@SuppressWarnings("unused")
	private static final int NAME = 1;
	@SuppressWarnings("unused")
	private static final int PASSOWRD = 2;
	private int field;
	
	public NameOrPasswordException() {
	}

	public NameOrPasswordException(int field,String message) {
		super(message);
		this.field=field;
	}

	public NameOrPasswordException(Throwable cause) {
		super(cause);
	}

	public NameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public NameOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public int getField() {
		return field;
	}

	public void setField(int field) {
		this.field = field;
	}
	
}

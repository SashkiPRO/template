package initialtask.com.exception;

public class DBException extends AppException {

    public DBException(String errCannotUpdateOrInsertDepartment) {
        super();
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}

package initialtask.com.dao.fileds;


public class Messages {
    private Messages() {
        throw new IllegalStateException("Util class");
    }

    public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "DataBase: Cannot obtain the data source";
    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "DataBase: Cannot obtain a connection from the pool";
    public static final String ERR_CANNOT_OBTAIN_DEPARTMENT_LIST = "Database:Cannot obtain a list of departments";
    public static final String ERR_CANNOT_DELETE_DEPARTMENT = "Database:Cannot delete department";
    public static final String ERR_CANNOT_FIND_EMPLOYEES_LIST = "Database:Cannot find employees list";
    public static final String ERR_CANNOT_DELETE_EMPLOYEE = "Database:Cannot delete employee";

    public static final String ERR_CANNOT_UPDATE_EMPLOYEE = "Database: Cannot update employee";
    public static final String ERR_CANNOT_FIND_EMPLOYEE_BY_ID = "Database: Cannot find employee by id";
    public static final String ERR_CANNOT_FIND_DEPARTMENT_BY_ID = "Database: Cannot find department by id";
    public static final String ERR_CANNOT_UPDATE_OR_INSERT_DEPARTMENT = "Database: Cannot update or insert department";
    public static final String ERR_CANNOT_FIND_EMPLOYEES_BY_EMAIL = "Cannot fond employee by email";


}

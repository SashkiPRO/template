package initialtask.com.dao.fileds;

public final class Path {
    public static final String UPDATE_DEPARTMENT_PAGE = "/update_department_form";
    public static final String UPDATE_EMPLOYEE_PAGE = "/employee/edit_employee";
    public static final String EMPLOYEES_LIST_PAGE = "/employee/employees";
    public static final String EDIT_DEPARTMENT_PAGE = "/department/edit_department";
    public static final String DEPARTMENT_LIST_PAGE = "/department/departments";
    public static final String EMPLOYEE_LIST_PAGE = "/employee_list";
    public static final String EMPLOYEE_UPDATE_PAGE = "/employee_update_form";
    private Path() {
        throw new IllegalStateException("Util class");
    }
}

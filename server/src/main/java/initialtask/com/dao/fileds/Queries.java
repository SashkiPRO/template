package initialtask.com.dao.fileds;

public final class Queries {
    private Queries() {
        throw new IllegalStateException("Util class");
    }

    public static final String FIND_ALL_DEPARTMENTS_QUERY = "SELECT * FROM department";
    public static final String FIND_EMPLOYEES_BY_DEPARTMENT = "SElECT * FROM employee WHERE department_id=?";
    public static final String FIND_ALL_EPLOYESS = "SELECT * FROM employee";
    public static final String REMOVE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE id = ?";
    public static final String REMOVE_DEPARTMENT_BY_ID = "DELETE FROM department WHERE id =?";
    public static final String INSERT_EMPLOYEE = "INSERT INTO employee (name,date_birth,salary, email,department_id) VALUES(?,?,?,?,?)";
    public static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id=? ";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET name=?, date_birth=?, salary=?, email=?, department_id=? WHERE id=?";
    public static final String UPDATE_DEPARTMENT = "UPDATE department SET name =? WHERE id=?";
    public static final String INSERT_DEPARTMENT = "INSERT INTO department (name) VALUES(?)";
    public static final String FIND_DEPARTMENT_BY_ID = "SELECT * FROM department WHERE id=?";
    public static final String FIND_DEPARTMENT_BY_NAME = "SELECT * FROM department WHERE name =?";
    public static final String FIND_EMPLOYEE_BY_EMAIL = "SELECT * FROM employee WHERE email=?";
}

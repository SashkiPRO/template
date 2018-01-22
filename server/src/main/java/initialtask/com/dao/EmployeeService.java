package initialtask.com.dao;

import initialtask.com.exception.DBException;
import initialtask.com.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EmployeeService {
    void update(Employee employee) throws DBException;

    List<Employee> findAll() throws DBException;

    void remove(int employeeId) throws DBException;

    List<Employee> findEmployeesByDepartmentId(int departmentID) throws DBException;

    Employee findEmployeeById(int employeeId) throws DBException;

    Employee findEmployeeByEmail(String email) throws DBException;
}

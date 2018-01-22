package initialtask.com.service.interfaces;

import initialtask.com.exception.DBException;
import initialtask.com.exception.ValidationException;
import initialtask.com.model.Employee;

import java.util.List;

public interface CRUDServiceEmployee {
    void updateEntity(Employee employee) throws ValidationException, DBException;

    void deleteEntity(Employee employee) throws DBException;

    List<Employee> getEntitiesList() throws DBException;

    List<Employee> getEntitiesListByDepartmentId(int departmentId) throws DBException;

    Employee findEmployeeById(int employeeId) throws DBException;

    Employee findEmployeeByEmail(String email) throws DBException;

}

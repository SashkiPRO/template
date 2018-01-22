package initialtask.com.service.interfaces;

import initialtask.com.exception.DBException;
import initialtask.com.exception.ValidationException;
import initialtask.com.model.Department;


import java.util.List;

public interface CRUDServiceDepartment {
    void updateEntity(Department department) throws ValidationException, DBException;

    void deleteEntity(Department department) throws DBException;

    List<Department> getEntitiesList() throws DBException;

    Department findDepartmentById(int id) throws DBException;

    Department findDepartmentByName(String name) throws DBException;
}

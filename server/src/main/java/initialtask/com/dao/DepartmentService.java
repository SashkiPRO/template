package initialtask.com.dao;

import initialtask.com.exception.DBException;
import initialtask.com.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DepartmentService {
    void update(Department department) throws DBException;

    List<Department> findAll() throws DBException;

    void remove(int departmentId) throws DBException;

    Department findDepartmnetById(int id) throws DBException;

    Department findDepartmentByName(String name) throws DBException;

}

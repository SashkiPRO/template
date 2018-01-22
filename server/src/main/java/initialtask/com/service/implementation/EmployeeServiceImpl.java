package initialtask.com.service.implementation;


import initialtask.com.dao.EmployeeService;
import initialtask.com.exception.DBException;
import initialtask.com.exception.ValidationException;
import initialtask.com.model.Employee;
import initialtask.com.service.interfaces.CRUDServiceEmployee;
import initialtask.com.util.ErrorMapGenerator;
import initialtask.com.util.ValidatorUtil;
import net.sf.oval.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements CRUDServiceEmployee {

    private EmployeeService employeeService;
    private ValidatorUtil validatorUtil;

    @Autowired
    public void setValidatorUtil(ValidatorUtil validatorUtil) {
        this.validatorUtil = validatorUtil;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Transactional
    public void updateEntity(Employee employee) throws ValidationException, DBException {
        if (employee == null) {
            employee = new Employee();
        }
        List<ConstraintViolation> list = validatorUtil.validate(employee);
        if (!list.isEmpty()) {
            throw new ValidationException(ErrorMapGenerator.getErrors(list));
        }
        employeeService.update(employee);
    }

    @Transactional
    public void deleteEntity(Employee employee) throws DBException {
        employeeService.remove(employee.getId());
    }

    @Transactional(readOnly = true)
    public List<Employee> getEntitiesList() throws DBException {
        return employeeService.findAll();
    }

    @Transactional(readOnly = true)
    public List<Employee> getEntitiesListByDepartmentId(int departmentId) throws DBException {
        return employeeService.findEmployeesByDepartmentId(departmentId);
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeById(int employeeId) throws DBException {
        return employeeService.findEmployeeById(employeeId);
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeByEmail(String email) throws DBException {
        return employeeService.findEmployeeByEmail(email);
    }


}

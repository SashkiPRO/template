package initialtask.com.service.implementation;

import initialtask.com.dao.DepartmentService;
import initialtask.com.exception.DBException;
import initialtask.com.exception.ValidationException;
import initialtask.com.model.Department;
import initialtask.com.service.interfaces.CRUDServiceDepartment;
import initialtask.com.util.ErrorMapGenerator;
import initialtask.com.util.ValidatorUtil;
import net.sf.oval.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements CRUDServiceDepartment {

    private DepartmentService departmentService;

    private ValidatorUtil validatorUtil;

    @Autowired
    public void setValidatorUtil(ValidatorUtil validatorUtil) {
        this.validatorUtil = validatorUtil;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Transactional
    public void updateEntity(Department department) throws ValidationException, DBException {
        if(department==null){
            department=new Department();
        }
        List<ConstraintViolation> list = validatorUtil.validate(department);
        if (!list.isEmpty()) {
            throw new ValidationException(ErrorMapGenerator.getErrors(list));
        }
        departmentService.update(department);
    }

    @Transactional
    public void deleteEntity(Department department) throws DBException {
        departmentService.remove(department.getId());
    }

    @Transactional(readOnly = true)
    public List<Department> getEntitiesList() throws DBException {
        return departmentService.findAll();
    }

    @Transactional(readOnly = true)
    public Department findDepartmentById(int id) throws DBException {
        return departmentService.findDepartmnetById(id);
    }

    @Transactional(readOnly = true)
    public Department findDepartmentByName(String name) throws DBException {
        return departmentService.findDepartmentByName(name);
    }


}

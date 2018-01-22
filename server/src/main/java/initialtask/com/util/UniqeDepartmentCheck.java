package initialtask.com.util;

import initialtask.com.exception.DBException;
import initialtask.com.model.Department;
import initialtask.com.service.interfaces.CRUDServiceDepartment;
import net.sf.oval.constraint.CheckWithCheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class UniqeDepartmentCheck implements CheckWithCheck.SimpleCheck {

    private static final Logger LOG = LoggerFactory.getLogger(UniqeDepartmentCheck.class);
    private transient CRUDServiceDepartment crudServiceDepartment;

    public boolean isSatisfied(Object validatedObject, Object value) {
        Department department = (Department) validatedObject;
        try {
            Department department1 = crudServiceDepartment.findDepartmentByName(value.toString());
            return department1 == null || department1.getId().equals(department.getId());
        } catch (DBException ex) {
            LOG.debug("Error with database connection");
            return false;

        }

    }
    public boolean isValide(Integer id, String departmentName){
        try{
            Department department = crudServiceDepartment.findDepartmentByName(departmentName);
            return department == null || department.getId().equals(id);
        }catch (DBException ex){
            LOG.debug("Error with database connection");
            return false;
        }
    }

    @Autowired
    public void setCrudServiceDepartment(CRUDServiceDepartment crudServiceDepartment) {
        this.crudServiceDepartment = crudServiceDepartment;
    }
}
package initialtask.com.util;

import initialtask.com.exception.DBException;
import initialtask.com.model.Employee;
import initialtask.com.service.interfaces.CRUDServiceEmployee;
import net.sf.oval.constraint.CheckWithCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class UniqeCheck implements CheckWithCheck.SimpleCheck {

    private static final Logger LOG = LoggerFactory.getLogger(UniqeCheck.class);
    private transient CRUDServiceEmployee crudServiceEmployee;

    public boolean isSatisfied(Object validatedObject, Object value) {
        Employee employee = (Employee) validatedObject;
        try {
            Employee employee1 = crudServiceEmployee.findEmployeeByEmail((String) value);
            return employee1 == null || employee1.getId().equals(employee.getId());
        } catch (DBException e) {
            LOG.debug("Error with database connection!");
            return false;
        }

    }
    public boolean isValid(String email, Integer id){
        try {
            Employee employee = crudServiceEmployee.findEmployeeByEmail(email);
            return employee == null || employee.getId().equals(id);
        } catch (DBException e) {
            LOG.debug("Error with database connection!");
            return false;
        }
    }
    @Autowired
    public void setCrudServiceEmployee(CRUDServiceEmployee crudServiceEmployee) {
        this.crudServiceEmployee = crudServiceEmployee;
    }
}

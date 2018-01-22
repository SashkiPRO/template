package initialtask.com.controller;


import initialtask.com.exception.DBException;
import initialtask.com.exception.ValidationException;
import initialtask.com.model.Employee;
import initialtask.com.service.interfaces.CRUDServiceDepartment;
import initialtask.com.service.interfaces.CRUDServiceEmployee;
import initialtask.com.util.UniqeCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private UniqeCheck uniqeCheck;
    private CRUDServiceDepartment crudServiceDepartment;

    private CRUDServiceEmployee crudServiceEmployee;

    @Autowired
    public void setCrudServiceDepartment(CRUDServiceDepartment crudServiceDepartment) {
        this.crudServiceDepartment = crudServiceDepartment;
    }

    @Autowired
    public void setCrudServiceEmployee(CRUDServiceEmployee crudServiceEmployee) {
        this.crudServiceEmployee = crudServiceEmployee;
    }

    @GetMapping(path = "/employee_list")
    public @ResponseBody
    List<Employee> displayEmployeeList(@RequestParam(required = false) Integer id) throws DBException {
        return crudServiceEmployee.getEntitiesListByDepartmentId(id);
    }

    @GetMapping(path = "/add_employee")
    @ResponseBody
    public Employee updateEmployeeForm(@RequestParam(required = false) Integer id) throws DBException {

        /*model.addAttribute("departments", crudServiceDepartment.getEntitiesList());
*/
        Employee employee = null;
        if (id != null) {
            employee = crudServiceEmployee.findEmployeeById(id);
        }
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    @PostMapping(path = "/update_employee")
    public @ResponseBody
    Employee updateEmployeeCommit(@RequestBody Employee employee) throws DBException {
        try {
            crudServiceEmployee.updateEntity(employee);
            return employee;
        } catch (ValidationException ex) {
            return null;
        }
    }

    @DeleteMapping(value = "/delete_employee/{id}")
    public @ResponseBody
    Employee deleteEmployee(@PathVariable Integer id) throws DBException {
        Employee delEmp = crudServiceEmployee.findEmployeeById(id);
        crudServiceEmployee.deleteEntity(delEmp);
        return delEmp;
    }

    @PostMapping(path = "/check_email")
    public @ResponseBody
    boolean testMethod(@RequestParam String email, @RequestParam(required = false) Integer id) {
        return uniqeCheck.isValid(email, id);
    }
}

package initialtask.com.controller;

import initialtask.com.exception.DBException;
import initialtask.com.exception.ValidationException;
import initialtask.com.model.Department;
import initialtask.com.service.interfaces.CRUDServiceDepartment;
import initialtask.com.util.UniqeDepartmentCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class DepartmentController {

    @Autowired
    private UniqeDepartmentCheck uniqeDepartmentCheck;

    private Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

    private CRUDServiceDepartment crudServiceDepartment;

    @Autowired
    public void setCrudServiceDepartment(CRUDServiceDepartment crudServiceDepartment) {
        this.crudServiceDepartment = crudServiceDepartment;
    }

    @GetMapping(path = {"/department_list"})
    public @ResponseBody
    List<Department> departmentList() throws DBException {
        return crudServiceDepartment.getEntitiesList();
    }

    @GetMapping(path = "/add_department")
    public @ResponseBody
    Department editDepartment(@RequestParam(required = false) Integer id) throws DBException {

        Department department = null;
        if (id != null) {
            department = crudServiceDepartment.findDepartmentById(id);
        }
        if (department == null) {
            department = new Department();
        }

        return department;
    }

    @PostMapping(path = "/update_department")
    public @ResponseBody
    Department updateDepartment(@RequestBody Department department) throws DBException {
        try {
            crudServiceDepartment.updateEntity(department);
            return department;
        } catch (ValidationException ex) {
            return null;

        }
    }

    @DeleteMapping(path = "/delete_department/{id}")
    public Department deleteDepartment(@PathVariable Integer id) throws DBException {
        Department department = crudServiceDepartment.findDepartmentById(id);
        crudServiceDepartment.deleteEntity(department);
        return department;

    }

    @PostMapping(path = "/check_name")
    public @ResponseBody boolean testMethod(@RequestParam String name,@RequestParam(required = false) Integer id){
        Integer id2 =id;
        return uniqeDepartmentCheck.isValide(id, name);
    }

}


import {departmentTable} from "rootDirectory/components/department/table/table";
import {employeeTable} from "rootDirectory/components/employee/table/table";
import {departmentForm} from "rootDirectory/components/department/form/form";
import {employeeForm} from "rootDirectory/components/employee/form/form";

export const appRoutes = [
    {
        "component": departmentTable,
        "path": `#department`

    },
    {
        "component": employeeTable,
        "path": `#employee_list`

    },
    {
        "component": departmentForm,
        "path": `#add_department`

    },
    {
        "component": employeeForm,
        "path": `#add_employee`

    }
];
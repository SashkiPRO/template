import Builder from "rootDirectory/util/builder";
import Service from "rootDirectory/service/service";
import validator from "rootDirectory/validation/validation";


class EmployeeForm {

    render () {

        $(`.content`).empty();
        const id = window.location.hash.split(`=`)[1];
        const promise = Service.getEntityList(`add_employee?id=${id}`);
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            div = $(`<div>`).addClass(`form-class col-lg-5`),
            panelHeading = $(`<div>`).addClass(`panel-heading`).
                text(`Employee form`),
            form = $(`<form>`).attr(`id`, `employee-form`),
            nameInput = Builder.inputCreator(
                `employee-name`,
                `name`, `name`, `text`, promise
            ),
            birthDate = Builder.inputCreator(
                `birthDate`, `birthDate`,
                `Date`, `date`, promise
            ),
            email = Builder.inputCreator(`email`, `email`, `Email`, `text`, promise),
            salary = Builder.inputCreator(
                `salary`, `salary`,
                `Salary`, `text`, promise
            ),
            department = Builder.inputCreator(`departmentId`, `departmentId`, `Department`, `text`, promise),
            idDiv = Builder.hiddenFieldBuilder(),
            submit = $(`<button>`).attr(`type`, `submit`).
                addClass(`btn btn-primary`).
                text(`Save`);

        form.append(idDiv).append(nameInput).
            append(birthDate).
            append(email).
            append(salary).
            append(department).
            append(submit);
        panelInfo.append(panelHeading).append(form);
        panelInfo.append(form);
        div.append(panelInfo);
        $(`.content`).append(div);

        validator.validationEmployeeFunction();

    }

}

export const employeeForm = new EmployeeForm();
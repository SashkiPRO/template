import Component from "rootDirectory/components/Component";

import validator from "rootDirectory/validation/validation";
import Service from "rootDirectory/service/service";
import Builder from "rootDirectory/util/builder";
import './form.scss'

class DepartmentForm extends Component {

    render () {

        $(`.content`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            div = $(`<div>`).addClass(`form-class col-lg-5`),
            panelHeading = $(`<div>`).addClass(`panel-heading`).
                text(`Department form`),
            form = $(`<form>`).attr(`id`, `department-form`),
            nameDiv = $(`<div>`).addClass(`lg-form`),
            nameInput = $(`<input>`).attr(`id`, `department-name`).
                addClass(`form-control`).
                attr(`name`, `name`).
                attr(`placeholder`, `Name`),
            idDiv = Builder.hiddenFieldBuilder(),
            submit = $(`<button>`).attr(`type`, `submit`).
                addClass(`btn btn-primary`).
                text(`Save`);
        const id = window.location.hash.split(`=`)[1];

        Service.getEntityList(`add_department?id=${id}`).then((out) => {

            nameInput.val(out.name);

        });

        nameDiv.append(nameInput);
        form.append(idDiv).append(nameDiv).
            append(submit);
        panelInfo.append(panelHeading).append(form);
        panelInfo.append(form);
        div.append(panelInfo);
        $(`.content`).append(div);

        validator.validationDepartmentFunction();

    }

}
export const departmentForm = new DepartmentForm();
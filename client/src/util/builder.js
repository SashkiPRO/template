import Service from "rootDirectory/service/service";

export default class Builder {

    static inputCreator (id, name, placeholder, type, promise) {

        const nameDiv = $(`<div>`).addClass(`lg-form`),
            nameInput = $(`<input>`).attr(`id`, id).
                addClass(`form-control`).
                attr(`name`, name).
                attr(`placeholder`, placeholder).
                attr(`type`, type);

        promise.then((out) => {

            nameInput.val(out[name]);

        });
        nameDiv.append(nameInput);

        return nameDiv;

    }

    static hiddenFieldBuilder () {

        const idDiv = $(`<div>`).addClass(`lg-form`),
            idInput = $(`<input>`).attr(`type`, `hidden`).
                attr(`name`, `id`).
                addClass(`form-control`);
        const id = window.location.hash.split(`=`)[1];

        idInput.val(id);
        idDiv.append(idInput);

        return idDiv;

    }

    static employeeListButton (id) {

        const button = $(`<button>`).addClass(`btn btn-primary`),
            td = $(`<td>`);

        button.text(`Employee list`);
        button.click(`click`, () => {

            window.location.hash = `employee_list?id=${id}`;

        });
        td.append(button);

        return td;

    }

    static editDepartmentButton (id, type) {

        const td = $(`<td>`),
            button = $(`<button>`).addClass(`btn btn-primary`);

        button.text(`Edit`);
        button.click(() => {

            if (type === `department`) {

                window.location.hash = `add_department?id=${id}`;

            } else {

                window.location.hash = `add_employee?id=${id}`;

            }

        });
        td.append(button);

        return td;

    }

    static deleteEntityButton (id, url, type) {

        const td = $(`<td>`);
        const button = $(`<button>`).addClass(`btn btn-primary`);

        button.text(`Delete`);
        button.on(`click`, () => {

            Service.deleteEntity(url, id);
            $(`#${type}${id}`).remove();

        });

        td.append(button);

        return td;

    }

    static printDepartmentRow (entity) {

        const row = $(`<tr>`).attr(`id`, `department${entity.id}`);

        row.append(`<td>${entity.name}</td>`);
        row.append(`<td>${entity.id}</td>`);
        row.append(this.deleteEntityButton(entity.id, `delete_department`, `department`));
        row.append(this.editDepartmentButton(entity.id, `department`));
        row.append(this.employeeListButton(entity.id));

        return row;

    }

    static printEmployeeRow (entity) {

        const row = $(`<tr>`).attr(`id`, `employee${entity.id}`);

        row.append(`<td>${entity.name}</td>`);
        row.append(`<td>${entity.id}</td>`);
        row.append(`<td>${entity.birthDate}</td>`);
        row.append(`<td>${entity.salary}</td>`);
        row.append(`<td>${entity.email}</td>`);
        row.append(this.deleteEntityButton(entity.id, `delete_employee`, `employee`));
        row.append(this.editDepartmentButton(entity.id, `employee`));

        return row;

    }

}
import $ from 'jquery';
import Service from "rootDirectory/service/service";
require(`jquery-validation`);
class Validator {

    // JQuery validation for department form
    validationDepartmentFunction () {

        $(`#department-form`).validate({
            "rules": {
                "name": {
                    "maxlength": 16,
                    "minlength": 2,
                    "remote": {
                        'data': {'id': $(`input[name="id"]`).val()},
                        "type": `POST`,
                        "url": `check_name`
                    },
                    "required": true

                }
            },
            "submitHandler": (form, event) => {

                event.preventDefault();

                Service.insertObject(
                    `/update_department`,
                    Service.toJsonString(form), `department`
                );

            }

        });

    }

    // JQuery validation for employee form
    validationEmployeeFunction () {

        $(`#employee-form`).validate({
            "rules": {
                "birthDate": {
                    "date": true,
                    "dateISO": true,
                    "required": true
                },
                "email": {

                    "email": true,
                    "remote": {
                        "data": {'id': $(`input[name="id"]`).val()},
                        "type": `POST`,
                        "url": `check_email`


                    },
                    "required": true
                },
                "name": {
                    "maxlength": 20,
                    "minlength": 2,
                    "required": true
                },
                "salary": {
                    "number": true,
                    "required": true
                }


            },
            submitHandler (form, event) {

                event.preventDefault();
                const url = `/update_employee`;

                Service.insertObject(
                    url,
                    Service.toJsonString(form), `employee`
                );

            }

        });

    }

}

const validator = new Validator();

export default validator;
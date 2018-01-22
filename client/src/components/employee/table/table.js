
import Component from "rootDirectory/components/Component";
// Import Navigation from "navigationPath/navigation";
import Service from "rootDirectory/service/service";
import Builder from "rootDirectory/util/builder";

class EmployeeTable extends Component {


    render () {

        //   Navigation.printNavigation();
        $(`.content`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            panelHeader = $(`<div>`).addClass(`panel-heading`).
                text(`Employees`),
            promiseArray = Service.getEntityList(window.location.hash.split(`#`)[1]),
            tabl = $(`<table>`),
            tbody = $(`<tbody>`);

        tabl.addClass(`table`);
        panelInfo.append(panelHeader);
        promiseArray.then((out) => {

            for (let i = 0; i < out.length; i++) {

                const row = Builder.printEmployeeRow(out[i]);

                tbody.append(row);

            }

        });
        tabl.append(tbody);
        panelInfo.append(tabl);
        $(`.content`).append(panelInfo);


    }


}
export const employeeTable = new EmployeeTable();
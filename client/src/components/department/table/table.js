import Component from "rootDirectory/components/Component";

// Import Navigation from "navigationPath/navigation";
import Builder from "rootDirectory/util/builder";
import Service from "rootDirectory/service/service";

class DepartmentTable extends Component {


    render () {

        //  Navigation.printNavigation();
        $(`.content`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            panelHeader = $(`<div>`).addClass(`panel-heading`).
                text(`Секас`),
            promiseArray = Service.getEntityList(`department_list`),
            tabl = $(`<table>`),
            tbody = $(`<tbody>`);

        tabl.addClass(`table`);
        panelInfo.append(panelHeader);
        promiseArray.then((out) => {

            for (let i = 0; i < out.length; i++) {

                const row = Builder.printDepartmentRow(out[i]);

                tbody.append(row);

            }

        });
        tabl.append(tbody);
        panelInfo.append(tabl);
        $(`.content`).append(panelInfo);


    }

}
export const departmentTable = new DepartmentTable();
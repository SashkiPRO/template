import {ParentModule} from "rootDirectory/module/module";
import {appRoutes} from "rootDirectory/approute";

class AppModule extends ParentModule {

    constructor (config) {

        super(config);

    }

}
export const appModule = new AppModule({"routes": appRoutes});
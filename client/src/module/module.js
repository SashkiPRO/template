import {router} from "rootDirectory/util/router";

export class ParentModule {

    constructor (config) {

        this.routes = config.routes;

    }

    start () {

        if (this.routes) {

            this.initRoutes();

        }

    }

    initRoutes () {

        window.addEventListener(`hashchange`, this.renderRoute.bind(this));
        this.renderRoute();

    }

    renderRoute () {

        const path = router.getUrl(),
            route = this.routes.find((routeUnit) => routeUnit.path === path);

        this.renderComponent(route.component);

    }

    renderComponent (component) {

        component.render();

    }


}
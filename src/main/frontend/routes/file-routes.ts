import type { AgnosticRoute } from "@vaadin/hilla-file-router/types.js";
import { createRoute } from "@vaadin/hilla-file-router/runtime.js";
import * as Page0 from "../views/@index.js";
import * as Page1 from "../views/welcome.js";
import * as Layout2 from "../views/@layout.js";
import * as Page2 from "../views/login";
import * as Page3 from "../views/cart-component.js";

const routes: readonly AgnosticRoute[] = [
    createRoute("", Layout2, [
        createRoute("", Page0),
        createRoute("welcome", Page1),
        createRoute("login", Page2),
        createRoute("cart", Page3),
    ])
];
export default routes;

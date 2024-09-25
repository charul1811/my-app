import type { AgnosticRoute } from "@vaadin/hilla-file-router/types.js";
import { createRoute } from "@vaadin/hilla-file-router/runtime.js";
import * as Page0 from "Frontend/views/@index.js";
import * as Page1 from "Frontend/themes/jewellery/components/cart-component";
import * as Page2 from "Frontend/themes/jewellery/components/login-component";
import * as Page3 from "Frontend/views/welcome.js";
import * as Layout4 from "Frontend/views/@layout.js";
const routes: readonly AgnosticRoute[] = [
    createRoute("", Layout4, [
        createRoute("", Page0),
        createRoute("cart-component", Page1),
        createRoute("login-component", Page2),
        createRoute("welcome", Page3)
    ])
];
export default routes;

import { RouterConfigurationBuilder } from '@vaadin/hilla-file-router/runtime.js';
import Flow from 'Frontend/generated/flow/Flow';
import fileRoutes from 'Frontend/generated/file-routes';
import MainLayout from "Frontend/views/@layout";
import LoginComponent from "Frontend/themes/jewellery/components/login-component";
import SignupComponent from "Frontend/themes/jewellery/components/signup-component";
import CartComponent from "Frontend/themes/jewellery/components/cart-component";

export const { router, routes } = new RouterConfigurationBuilder()
    .withFileRoutes(fileRoutes) // (1)
    // To define routes manually or adding an individual route, use the
    // following code and remove (1)
    .withReactRoutes(
        [
            {
                element: <MainLayout/>,
                handle: {title: 'Main'},
                children: [
                    //             { path: '/hilla', element: <HillaView />, handle: { title: 'Hilla' } }
                    //         ],
                    //       },
                    {path: '/login', element: <LoginComponent/>, handle: {title: 'Login'}},
                    {path:'/signup', element: <SignupComponent/>, handle: {title: 'Signup'}},
                    {path:'/cart', element: <CartComponent/>, handle: {title: 'Cart'}},
                ]
                // )
                // OR
                // .withReactRoutes(
                //   [
                //     { path: '/login', element: <Login />, handle: { title: 'Login' } }
            }]
    )
    .withFallback(Flow)
    // Optional method that adds an authentication for routes.
    // Can take an optional path to redirect to, if not authenticated:
    // .protect('/login');
    .protect()
    .build();

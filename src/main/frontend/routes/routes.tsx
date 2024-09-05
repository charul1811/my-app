import LoginComponent from "Frontend/themes/jewellery/components/login-component";
import SignupComponent from "Frontend/themes/jewellery/components/signup-component";
import CartComponent from "Frontend/themes/jewellery/components/cart-component";
import {createBrowserRouter} from "react-router-dom";

export const  routes = [

    { path: '/welcome', component: 'welcome' },
    { path: '/', component: '@index' },
    {path:'/login',element:<LoginComponent/>},
    {path:'/signup',element:<SignupComponent/>},
    {path:'/cart',element:<CartComponent/>},

]
export const router = createBrowserRouter(routes)
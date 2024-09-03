import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import ProductComponent from "Frontend/themes/jewellery/components/product-component";
import {Button} from "@material-ui/core";
import LoginComponent from "Frontend/themes/jewellery/components/login-component";
import {Link} from "react-router-dom";
import {login} from "@vaadin/hilla-frontend";

export const config: ViewConfig = { menu: { order: 0, icon: 'line-awesome/svg/accusoft.svg' }, title: 'Home' };
const topRight = {
    position: 'absolute',
    top: '100px',
    right: '100px',

    fontSize: '18px',
    width: '50px',
};
interface HomeViewProps {
    iconStyle: React.CSSProperties | undefined
}

export default function HomeView({iconStyle}: HomeViewProps) {
  return (
    /*<div className="flex flex-col h-full items-center justify-center p-l text-center box-border">*/

      <div>
      <img style={{ width: '200px' }} src="images/logo%202.png" />

          <span {...{ theme: 'badge' }}><Link to="/login" style={topRight} ><img  width={"50 px"} src="images/img.png" alt="324" />User Login </Link></span>
      <h2>This place is intended for jewelry lovers</h2>
      <p>It’s a place where you can choose your style 🤗</p>
        <div>  <ProductComponent/> </div>
    </div>
  );
}

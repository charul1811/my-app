import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import ProductComponent from "Frontend/themes/jewellery/components/product-component";

export const config: ViewConfig = { menu: { order: 0, icon: 'line-awesome/svg/accusoft.svg' }, title: 'Home' };
const topRight = {
    position: 'absolute',
    bottom: '3px',
    left: '45px',
    fontSize: '18px',
    width: '50px',
};
export default function HomeView() {
  return (
    /*<div className="flex flex-col h-full items-center justify-center p-l text-center box-border">*/

      <div>
      <img style={{ width: '200px' }} src="images/logo%202.png" />
          <img style={topRight} src="images/img.png" alt="324" />
      <h2>This place is intended for jewelry lovers</h2>
      <p>It’s a place where you can choose your style 🤗</p>
        <div>  <ProductComponent/> </div>
    </div>
  );
}

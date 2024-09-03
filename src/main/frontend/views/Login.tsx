import React from 'react';
import {LoginForm} from "@vaadin/react-components";


function Example() {
    return (
        <>
            {/* no-autofocus is used to prevent the example from stealing focus when browsing the
      documentation */}
            <LoginForm no-autofocus />
        </>
    );
}
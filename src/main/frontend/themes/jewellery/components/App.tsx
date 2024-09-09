import {Routes, Route, RouterProvider} from 'react-router-dom';
import {router} from "Frontend/routes/routes";
import React from "react";

function App() {

    return <RouterProvider router={ router}    />
}


export default App;

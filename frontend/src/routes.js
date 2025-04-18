import {createBrowserRouter} from "react-router-dom";
import Dashboard from "./components/Dashboard";
import Manage from "./components/Manage";
import Home from "./components/Home";
import Login from "./components/Login";
import ProtectedRoute from "./components/ProtectedRoute";

const router = createBrowserRouter([
    {
        path:"/",
        element: (
            <ProtectedRoute>
                <Dashboard/>
            </ProtectedRoute>
        ),
        children: [
            {
                index:true, //this makes it the default route
                element: <Home/> //show Home component by default
            },
            {
                path: "/manage",
                element: <Manage/>,
            }
        ]
    },
    {
        path:"/login",
        element:<Login/>
    }
]);

export default router;
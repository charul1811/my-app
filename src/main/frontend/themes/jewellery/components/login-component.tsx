import React, { useState } from 'react';
import {Link, NavLink, useNavigate} from 'react-router-dom';
import {Grid} from "@material-ui/core";
import {UserService} from "Frontend/generated/endpoints";
import {Notification} from "@vaadin/react-components/Notification";



// Define a UserLogin type
interface User {
    email: string;
    password: string;
}

const Login: React.FC = () => {
    const [user, setUser] = useState<User>({ email: '', password: '' });
    const [message, setMessage] = useState<string | null>(null);
    const navigate = useNavigate(); // Hook to navigate programmatically

    // Handle input changes
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setUser({ ...user, [name]: value });
    };

    // Handle form submission


    return (
        <div>
            <h2>Login</h2>
            <form >
                <div>
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        value={user.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={user.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit"
                        onClick={ async () => {
                            const serverResponse = await UserService.getUserByEmail(user);
                            Notification.show("Login Successful" + serverResponse);
                        }}


                >Login</button>
                <Grid item xs>
                    <Link to="/forgot-password" >
                        Forgot password?
                    </Link>
                </Grid>
                <p>
                    Don't have an account? <NavLink to="/signup">Sign up here</NavLink>
                </p>
            </form>
            {message && <p>{message}</p>}

        </div>
    );
};

export default Login;

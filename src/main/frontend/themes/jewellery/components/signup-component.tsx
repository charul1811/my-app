import React, { useState } from 'react';
import {Grid, makeStyles} from "@material-ui/core";
import {Link} from "react-router-dom";
import {CartItemService, UserService} from "Frontend/generated/endpoints";
import {Notification} from "@vaadin/react-components/Notification";


// Define the props for the form component if needed

const useStyles = makeStyles((theme) => ({
    heading: {
        textAlign: "center",
        margin: theme.spacing(1, 0, 4),
    },
    submitButton: {
        marginTop: theme.spacing(4),
    },
}));
// Define a User type to be consistent with our backend entity
interface User {
    email: string;
    password: string;
}

const Signup: React.FC = () =>  {
    const [user, setUser] = useState<User>({ email: '', password: '' });
    const [message, setMessage] = useState<string | null>(null);
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setUser({ ...user, [name]: value });
    };
    // Handle input changes

    return (
        <div >
            <h2>Sign Up</h2>
            <form   >

                <div className="form-group">
                    <label htmlFor="email">Email:</label>
                    <input

                        className="form-control"
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
                <button
                    className="btn btn-primary"
                    onClick={async () => {
                        await UserService.save(user);
                        Notification.show("user saved");
                    }}
                    type="submit">Sign Up</button>
                <Grid item>
                    <Link to="/login">Already have an account? Log in</Link>
                </Grid>
            </form>
            {message && <p>{message}</p>}
        </div>


    );
};

export default Signup;

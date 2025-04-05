import '../css/Login.css';
import StyleOutlinedIcon from '@mui/icons-material/StyleOutlined';
import {useState} from "react";
import axios from "axios";
function Login(){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    //handle form submission
    const handleLogin = (e) => {
        e.preventDefault(); // Prevent form from refreshing the page

        //Build payload
        const credentials = {username, password};

        //Send POST request to the auth endpoints.
        //Note: Since our axiosConfig base URL doesn't apply here.
        //We're using axios directly with full URL.
        axios.post("http://localhost:8080/api/auth/login", credentials, {
            headers: {"Content-Type":"application/json"}
        })
            .then((response) => {
                //Assuming the token is returned in the response body.
                const token = response.data;
                console.log("Login successful! Token: ", token);
                //Save the token in localStorage or Redux Store.
                localStorage.setItem("token", token);
            })
            .catch((error) => {
                console.error("Login error: ", error.response ? error.response.data : error.message)
                setError("Invalid username or password");
            })
    }

    return(
      <section className="Login-section">
          <div className="Main-div-left">
              <StyleOutlinedIcon className="LogoIcon"/>
              <p>Book management system</p>
          </div>
          <div className="Main-div-right">
                <div className="right-main-div">
                    <div className="right-main-div-title">
                        <h2>Log in to your account</h2>
                        <p>Enter your username and password below to log in</p>
                    </div>
                    <form onSubmit={handleLogin} className="right-main-div-content">
                        <div className="right-main-div-content-field">
                            <p>Username</p>
                            <input type="text" value={username} onChange={(e) => setUsername(e.target.value)}/>
                        </div>
                        <div className="right-main-div-content-field">
                            <p>Password</p>
                            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                        </div>
                        <div className="right-main-div-content-checkBox">
                            <input type="checkbox"/>
                            <p>Remember me</p>
                        </div>
                        {error && <p style={{color:"red"}}>{error}</p>}
                        <div className="right-main-div-content-button">
                            <button type="submit">Login</button>
                        </div>
                    </form>
                </div>
          </div>
      </section>
    );
}

export default Login;
import '../css/Login.css';
import StyleOutlinedIcon from '@mui/icons-material/StyleOutlined';
import {useState} from "react";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import {loginUser} from "../features/authSlice";
function Login(){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const {loading, error, token} = useSelector((state) => state.auth);

    //handle form submission
    const handleLogin = async (e) => {
        e.preventDefault(); // Prevent form from refreshing the page
        try {
            const resultAction = await dispatch(loginUser({ username, password })).unwrap();
            console.log("Login successful, token:", resultAction);
            //After successful login, navigate to dashboard
            navigate('/');
        }catch (err){
            console.error("Login failed.", err);
        }
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
                            <button type="submit" disabled={loading}>Login</button>
                        </div>
                    </form>
                </div>
          </div>
      </section>
    );
}

export default Login;
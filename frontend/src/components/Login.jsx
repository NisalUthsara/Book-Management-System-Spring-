import '../css/Login.css';
import StyleOutlinedIcon from '@mui/icons-material/StyleOutlined';
function Login(){
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
                        <p>Enter your email and password below to log in</p>
                    </div>
                    <div className="right-main-div-content">
                        <div className="right-main-div-content-field">
                            <p>Email Address</p>
                            <input type="email"/>
                        </div>
                        <div className="right-main-div-content-field">
                            <p>Password</p>
                            <input type="password"/>
                        </div>
                        <div className="right-main-div-content-checkBox">
                            <input type="checkbox"/>
                            <p>Remember me</p>
                        </div>
                        <div className="right-main-div-content-button">
                            <button>Login</button>
                        </div>
                    </div>
                </div>
          </div>
      </section>
    );
}

export default Login;
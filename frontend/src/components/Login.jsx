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
                    <div>
                        <h2>Log in to your account</h2>
                        <p>Enter your email and password below to log in</p>
                    </div>
                    <div>
                        <div>
                            <p>Email Address</p>
                            <input/>
                        </div>
                        <div>
                            <p>Password</p>
                            <input/>
                        </div>
                        <div>
                            <input type="checkbox"/>
                            <p>Remember me</p>
                        </div>
                        <div>
                            <button>Login</button>
                        </div>
                    </div>
                </div>
          </div>
      </section>
    );
}

export default Login;
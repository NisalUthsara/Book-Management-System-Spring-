import '../css/Dashboard.css'
import MenuIcon from '@mui/icons-material/Menu';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import BookList from "./BookList";
function Dashboard() {
    const viewMenuIcon = () => {
        const sideBar = document.getElementsByClassName("main-sidebar")[0];
        if (sideBar){
            sideBar.classList.toggle('show');
        }
    };

    return (
        <div className="main-div">
            <div className="main-sidebar">
                <div className="main-sidebar-title">
                    <h2>Book Management System</h2>
                </div>
                <div className="main-sidebar-btn-div">
                    <button>Home</button>
                    <button>Manage</button>
                    <button>Profile</button>
                </div>
                <div>
                    <button>Logout</button>
                </div>
            </div>
            <div className="main-layout">
                <div className="main-layout-header">
                    <div className="main-layout-header-menuIcon">
                        <a onClick={viewMenuIcon}><MenuIcon/></a>
                    </div>
                    <div className="main-layout-header-icons">
                        <AccountCircleIcon/>
                    </div>
                </div>
                <hr/>
                <div className="main-layout-body">
                    <h1>Book Lists :</h1>
                    <BookList/>
                </div>
            </div>
            <div></div>
        </div>
    );
}

export default Dashboard;
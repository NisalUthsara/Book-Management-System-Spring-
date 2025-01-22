import '../css/Dashboard.css'
import MenuIcon from '@mui/icons-material/Menu';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
function Dashboard() {
    const viewMenuIcon = () => {
        const sideBar = document.getElementsByClassName("main-sidebar")[0];
        if (sideBar){
            sideBar.style.display = 'block';
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
                <div className="main-layout-body"></div>
            </div>
            <div></div>
        </div>
    );
}

export default Dashboard;
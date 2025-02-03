import '../css/Home.css'
import BookList from "./BookList";
import MenuBookRoundedIcon from '@mui/icons-material/MenuBookRounded';
import SellRoundedIcon from '@mui/icons-material/SellRounded';
import EventRoundedIcon from '@mui/icons-material/EventRounded';

function Home() {
    return(
        <div className="Home-main-div">
            <div className="Home-content-s1">
                <div className="Home-content-s1-box1">
                    <div className="Home-content-s1-box1-text-div">
                        <h3>Amount of Books</h3>
                        <h1>100</h1>
                    </div>
                    <div className="Home-content-s1-box1-icon-div">
                        <MenuBookRoundedIcon className="BookIcon"/>
                    </div>
                </div>
                <div className="Home-content-s1-box2">
                    <div className="Home-content-s1-box2-text-div">
                        <h3>Number of Books sold</h3>
                        <h1>20</h1>
                    </div>
                    <div className="Home-content-s1-box2-icon-div">
                        <SellRoundedIcon className="SellIcon"/>
                    </div>
                </div>
                <div className="Home-content-s1-box3">
                    <div className="Home-content-s1-box3-text-div">
                        <h3>Today's sales count</h3>
                        <h1>4</h1>
                    </div>
                    <div className="Home-content-s1-box3-icon-div">
                        <EventRoundedIcon className="CalanderIcon"/>
                    </div>
                </div>
            </div>
            <div className="Home-content-s2">
                <h1>Book Lists:</h1>
                <BookList/>
            </div>
        </div>
    );
}

export default Home;
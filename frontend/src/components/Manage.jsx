import '../css/Manage.css'
import {useState} from "react";
import axiosConfig from "../api/axiosConfig";
import api from "../api/axiosConfig";

function Manage() {
    const [book, setBook] = useState({
        title:"",
        author:"",
        genre:"",
        price:"",
        publishedDate:""
    })

    //handle input change
    const handleChange = (e) => {
        setBook({ ...book, [e.target.name]: e.target.value });
    };

    //handle form submission(Add book)
const handleSubmit = ()=> {
    const formattedBook = {
        ...book,
        publishedDate: book.publishedDate ? new Date(book.publishedDate).toISOString() : null
    };

        api.post("/createBook",formattedBook)
            .then((response) => {
                console.log("Book added successfully.! ", response.data);
                alert("Book added successfully.!");
                setBook({
                    title: "",
                    author: "",
                    genre: "",
                    publishedDate: "",
                    price: "",
                });
            })
            .catch((error) => {
                console.log("Error adding book: ", error.response ? error.response.data : error.message);
                alert("Failed to add book!");
            });
}

    return(
        <div className="Manage-content">
            <div className="Manage-content-s1">
                <h2>Add a book</h2>
                <div className="Manage-content-s1-addSection">
                    <div className="Manage-content-s1-addSection-title">
                        <label>Title*</label>
                        <input type="text" name="title" value={book.title} onChange={handleChange} className="Section-input addSection-input-title"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label>Author*</label>
                        <input type="text" name="author" value={book.author} onChange={handleChange} className="Section-input addSection-input-author"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label>Genre*</label>
                        <input type="text" name="genre" value={book.genre} onChange={handleChange} className="Section-input addSection-input-genre"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label>Published Date</label>
                        <input type="date" name="publishedDate" value={book.publishedDate} onChange={handleChange} className="Section-input addSection-input-date"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label>Price*</label>
                        <input type="number" name="price" value={book.price} onChange={handleChange} className="Section-input addSection-input-price"/>
                    </div>
                    <div className="Manage-content-s1-addSection-button">
                        <button className="Section-button" onClick={handleSubmit}>Add</button>
                        <button className="Section-button">Update</button>
                    </div>
                </div>
            </div>
            <div className="Manage-content-s2"></div>
        </div>


    );
}

export default Manage;
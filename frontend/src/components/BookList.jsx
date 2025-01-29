import {useEffect, useState} from "react";
import api from "../api/axiosConfig";

const BookList = () => {
    const [books,setBooks] = useState([]);

    useEffect(() => {
        api
            .get('/getAllBooks')
            .then((response) => {
                setBooks(response.data);
            })
            .catch((error) => {
                console.error("There was an error fetching the books!", error);
            });
    }, []);

    return(
      <div>
          <h2>Available Books</h2>
          <ul>
              {books.map((book) => (
                  <li key={book.id}>
                      <b>{book.title}</b> by {book.author}
                  </li>
              ))}
          </ul>
      </div>
    );
};

export default BookList;
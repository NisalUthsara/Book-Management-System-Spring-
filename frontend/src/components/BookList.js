import {useEffect, useState} from "react";
import api from "../api/axiosConfig";

const BookList = () => {
    const [books,setBooks] = useState([]);

    useEffect(() => {
        const fetchBooks = async () => {
            try {
                const response = await api.get('/getAllBooks');
                setBooks(response.data);
            }catch (error) {
                console.error('Error fetching books: ', error);
            }
        };

        fetchBooks();
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
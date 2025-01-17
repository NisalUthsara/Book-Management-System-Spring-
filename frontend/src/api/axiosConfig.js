import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080/api/v2/books', //update the base URL to match my backend
});

export default api;
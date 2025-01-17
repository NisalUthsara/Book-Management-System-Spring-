import axios from "axios";

//You can set a base URL or headers globally so you don’t repeat them in every request
const api = axios.create({
    baseURL: 'http://localhost:8080/api/v2/books', //update the base URL to match my backend
});

export default api;
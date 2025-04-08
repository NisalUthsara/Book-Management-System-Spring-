import axios from "axios";
import store from "../store";

//You can set a base URL or headers globally so you don’t repeat them in every request
const api = axios.create({
    baseURL: 'http://localhost:8080/api/v2/books', //update the base URL to match my backend
});

//Add a request interceptor
api.interceptors.request.use(
    (config) => {
        //Get the token from Redux state
        const token = store.getState().auth.token;
        if (token){
            //Append the token to the Authorization header if present
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default api;
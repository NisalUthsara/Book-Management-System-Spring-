import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";

//Define an async thunk for login
export const loginUser = createAsyncThunk(
    'auth/loginUser',
    async (credentials, thunkAPI) => {
        try {
            const response = await axios.post("http://localhost:8080/api/auth/login", credentials, {
                headers: {"Content-Type": "application/json"}
            });
            return response.data; //The token
        }catch (error){
            return thunkAPI.rejectWithValue(error.response.data);
        }
    }
);

const authSlice = createSlice({
    name : 'auth',
    initialState : {
        token : null,
        loading: false,
        error : null,
    },
    reducers : {
        logout : (state) => {
            state.token = null;
            //You could also remove token from localstorage here if using redux-persist
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(loginUser.pending, (state) => {
                state.loading = true;
                state.error = null;
            })
            .addCase(loginUser.fulfilled, (state, action) => {
                state.loading = false;
                state.token = action.payload;
            })
            .addCase(loginUser.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload;
            });
    },
});

export const  {logout} = authSlice.actions;
export default authSlice.reducer;


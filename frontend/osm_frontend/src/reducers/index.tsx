import * as redux from "redux";
import districtReducer from './districtReducer';

export default redux.combineReducers(
    {
        districts: districtReducer.call
    }
);

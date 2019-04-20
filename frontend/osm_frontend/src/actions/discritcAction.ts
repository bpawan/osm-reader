import {FETCH_DISTRICTS} from "./types";
import {Dispatch} from "redux";

export function fetchDistricts() {
    return function (dispatch: Dispatch) {
        fetch("http://localhost:9090/district/index")
            .then(res => res.json())
            .then(
                districts => dispatch(
                    {type: FETCH_DISTRICTS, payload: districts}
                )
            );
    }
}

import {District, FETCH_DISTRICTS, FetchDistrictAction, FetchDistrictState, NEW_DISTRICT} from "../actions/types";

const items: District[] = [];
const initialState: FetchDistrictState = {
    items: items,
    item: null
};

export default function (state: FetchDistrictState = initialState, action: FetchDistrictAction) {
    switch (action.type) {
        case FETCH_DISTRICTS:
            return {
                ...state,
                items: action.payload
            };
        case NEW_DISTRICT:
            return {
                ...state,
                item: action.payload
            };
        default:
            return state;
    }
};

import {Action} from "redux";

export const FETCH_DISTRICTS = "FETCH_DISTRICT";
export const NEW_DISTRICT = "NEW_DISTRICT";

export interface District {
    id: number
    name: string
    numberOfVDCs: number
    numberOfMunicipalities: number
}

export interface FetchDistrictState {
    items: District[],
    item: District | null
}

export interface DistrictDataProps {
    districts: FetchDistrictState | null
    fetchDistricts: any
}

export interface FetchDistrictAction extends Action {
    payload: District[];
}

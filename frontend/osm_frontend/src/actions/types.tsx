import {Action} from "redux";

export const FETCH_DISTRICTS = "FETCH_DISTRICT";
export const NEW_DISTRICT = "NEW_DISTRICT";

export const ADD_PROVINCE = "ADD_PROVINCE";
export const EDIT_PROVINCE = "EDIT_PROVINCE";
export const LIST_PROVINCE = "LIST_PROVINCE";

export interface ProvinceFeature {
    key: string
    value: string
}

export interface ProvincePopulation {
    id: number
    total: number;
    rank: number;
    density: number;
    densityRank: number;
}

export interface AdministrativeProvince {
    id: number
    englishName: string
    nepaliName: string
    normalizedName: string
    capitalCity: string
    website: string
    districtCount: number
    area: number
    areaRank: number
    provincePopulation: ProvincePopulation
    features: ProvinceFeature[]
}

export interface AdministrativeProvinceAction  extends Action {
    payload: AdministrativeProvince[]
}

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

import {
    ADD_PROVINCE,
    AdministrativeProvince,
    AdministrativeProvinceAction, EDIT_PROVINCE, LIST_PROVINCE,
    ProvinceFeature,
    ProvincePopulation
} from "../actions/types";

const initialState = <AdministrativeProvince>{
    id: 0,
    englishName: '',
    nepaliName: '',
    normalizedName: '',
    capitalCity: '',
    website: '',
    districtCount: 0,
    area: 0,
    areaRank: 0,
    provincePopulation: <ProvincePopulation>{
        id: 0,
        total: 0,
        rank: 0,
        density: 0,
        densityRank: 0
    },
    features: <ProvinceFeature[]>[<ProvinceFeature>{
        key: '',
        value: ''
    }]
};

export default () => {
    return (state: AdministrativeProvince = initialState, action: AdministrativeProvinceAction) => {
        switch (action.type) {
            case ADD_PROVINCE:
                console.log("adding the province");
                return {
                    ...state,
                    province: action.payload
                };
            case EDIT_PROVINCE:
                console.log("editing province");

                return {
                    ...state,
                    province: action.payload
                };
            case LIST_PROVINCE:
                console.log("listing provinces");
                return {
                    ...state,
                    provinceList: action.payload
                };
            default:
                return state;
        }
    };
};

import {AdministrativeProvinceAction, EDIT_PROVINCE, LIST_PROVINCE} from "./types";
import {Dispatch} from "redux";

export class AdministrativeAction {
    private readonly baseUrl: string;
    private readonly context: string;


    private readonly LIST_PROVINCE_ACTION: string = "index";
    private readonly PROVINCE_BY_ID_ACTION: string = "/find";

    private readonly CONTENT_TYPE = "application/json";
    private readonly HTTP_GET: string = "GET";

    constructor(baseUrl: string, context: string) {
        this.baseUrl = baseUrl;
        this.context = context;
    }

    public fetcAdministrativeProvinces = () => (dispatch: Dispatch) => {
        fetch(this.createRequest(this.LIST_PROVINCE_ACTION, this.HTTP_GET))
            .then(res => res.json())
            .then(value => {
                    dispatch(<AdministrativeProvinceAction>{
                        payload: value,
                        type: LIST_PROVINCE
                    })
                }
            );
    };

    public fetchAdministrativeProviceById = () => (dispatch: Dispatch) => {
        fetch(this.createRequest(this.PROVINCE_BY_ID_ACTION, this.HTTP_GET))
            .then(res => res.json())
            .then(value => {
                    dispatch(<AdministrativeProvinceAction>{
                        type: EDIT_PROVINCE,
                        payload: value
                    })
                }
            );
    };

    private createUrl = (action: string): string => {
        return this.baseUrl + this.context + action;
    };

    private createHeaders = (): Headers => {
        const headers = new Headers();
        headers.append("Content-Type", this.CONTENT_TYPE);

        return headers;
    };

    private createRequest = (method: string, url: string): RequestInfo => {
        return <RequestInfo>{
            url: this.createUrl(url),
            method: method,
            headers: this.createHeaders()
        };
    };
}

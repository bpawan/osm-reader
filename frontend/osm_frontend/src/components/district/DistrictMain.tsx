import * as React from 'react';
import  {Header} from "../common/Header";
import {Footer} from "../common/Footer"
import DistrictData from "./DistrictData"
import {DistrictForm} from "./DistrictForm"

export class DistrictMain extends React.Component<any, any> {
    render(): React.ReactNode {
        return <div className="District">
            <Header/>
            <main className="flex-shrink-0" role="main">

                <div className="container">
                    <br />
                    <br />
                    <br />
                    <div className="row">
                        <div className="col">
                            <DistrictData />
                        </div>
                        <div className="col">
                            <br/>
                            <DistrictForm/>
                        </div>
                    </div>
                </div>
            </main>
            <Footer/>
        </div>;
    }
}

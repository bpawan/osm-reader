import * as React from "react";
import {IndexPageMap} from './IndexPageMap';

export class Main extends React.Component {
    render() {
        return (
            <main className="flex-shrink-0" role="main">
                <div className="container">
                    <div className="alert alert-primary" role="alert">Welcome to awesome map</div>
                    <div className="row">
                        <div className="col-12 map-container">
                            <br/>
                            <IndexPageMap/>
                        </div>
                    </div>
                </div>
            </main>
        );
    }
}

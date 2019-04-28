import 'bootstrap/dist/css/bootstrap.min.css';
import 'leaflet/dist/leaflet.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './css/index.css';

import * as React from "react";
import * as ReactDOM from 'react-dom';
import {App} from './components/common/App';
import {ProvinceMain} from './components/administrative/ProvinceMain';
import {Route, Router} from "react-router"
import {Provider} from 'react-redux'
import store from './store'

import {createBrowserHistory} from "history"

import {DistrictMain} from './components/district/DistrictMain';

const history = createBrowserHistory();

const provider = (
    <Provider store={store}>
        <Router history={history}>
            <Route exact path="/" component={App}/>
            <Route path="/district/" component={DistrictMain}/>
            <Route path="/administrative/province" component={ProvinceMain}/>
        </Router>
    </Provider>
);

const rootElement = document.getElementById('root');

ReactDOM.render(provider, rootElement);


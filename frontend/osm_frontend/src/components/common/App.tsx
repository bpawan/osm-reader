import * as React from 'react';

import '../../css/App.css';
import '../../css/index.css';
import {Header} from './Header';
import {Main} from '../index/Main';
import {Footer} from './Footer';

export class App extends React.Component {
    render() {
        return (
            <div className="App">
                <Header/>
                <Main/>
                <Footer/>
            </div>
        );
    }
}

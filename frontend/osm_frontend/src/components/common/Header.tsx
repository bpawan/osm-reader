import * as React from 'react';
import {Component} from "react";

export class Header extends Component {
    render() {
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                    <a className="navbar-brand" href="/">Home</a>
                    <button aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation"
                            className="navbar-toggler"
                            data-target="#navbarCollapse" data-toggle="collapse" type="button">
                        <span className="navbar-toggler-icon"/>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <a className="nav-link active" href="/district/">Districts</a>
                            </li>

                            <li className="nav-item">
                                <a className="nav-link" href="#a">Link</a>
                            </li>

                        </ul>
                        <form className="form-inline mt-2 mt-md-0">
                            <input aria-label="Search" className="form-control mr-sm-2" placeholder="Search"
                                   type="text"/>
                            <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </nav>
            </header>
        );
    }
}

import * as React from 'react';

import {Map, Polygon as PolygonObject, TileLayer} from 'react-leaflet';
import {LatLngTuple} from "leaflet";
import {FeatureCollection, GeoJsonProperties, Polygon} from "geojson";


export class IndexPageMap extends React.Component<{}, {
    error: any,
    isLoaded: boolean,
    districtData: FeatureCollection<Polygon, GeoJsonProperties>,
    lat: number,
    lng: number,
    zoom: number,
}> {
    constructor(props: any) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            districtData: {features: [], type: "FeatureCollection"},
            lat: 28.394857,
            lng: 84.124008,
            zoom: 7
        };
    }

    componentWillMount() {
        fetch("http://localhost:9090/lines/tpj")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        districtData: result
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    createPolygonCoordinates(districtData: FeatureCollection<Polygon, GeoJsonProperties>): LatLngTuple[] {
        const coordinates: LatLngTuple[] = [];
        districtData.features.forEach(value => {
            value.geometry.coordinates.forEach(a => {
                a.forEach(x => {
                    coordinates.push([x[1], x[0]]);
                });
            })
        });

        return coordinates;
    }

    render() {
        const position: LatLngTuple = [this.state.lat, this.state.lng];
        const poly: LatLngTuple[] = this.createPolygonCoordinates(this.state.districtData);

        return (
            <Map center={position} zoom={this.state.zoom}>
                <PolygonObject color="purple" positions={poly}/>
                <TileLayer
                    attribution='&amp;copy <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />
            </Map>
        );
    }
}

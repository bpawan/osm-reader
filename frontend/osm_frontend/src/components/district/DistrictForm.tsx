import * as React from 'react';

export class DistrictForm extends React.Component<any, any> {
    constructor(props: any) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);
        this.onChange = this.onChange.bind(this);

        this.state = {
            districtName: "",
            numberOfVDCs: "",
            numberOfMunicipalities: ""
        };
    }

    public render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <label htmlFor="exampleInputEmail1">District Name </label>
                    <input required type="text" name="districtName" className="form-control" id="districtName"
                           aria-describedby="districtNameHelp"
                           placeholder="Enter District Name" value={this.state.districtName} onChange={this.onChange}/>
                </div>
                <div className="form-group">
                    <label htmlFor="numberOfVDC">Number of VDCs</label>
                    <input required type="number" name="numberOfVDCs" className="form-control" id="numberOfVDCs"
                           placeholder="Number of VDCs" value={this.state.numberOfVDCs} onChange={this.onChange}/>
                </div>
                <div className="form-group">
                    <label htmlFor="numberOfMunicipalities">Number of Municipalities</label>
                    <input required type="number" name="numberOfMunicipalities" className="form-control"
                           id="numberOfMunicipalities"
                           placeholder="Number of Municipalities" value={this.state.numberOfMunicipalities}
                           onChange={this.onChange}/>
                </div>

                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        );
    }

    private onChange(e: any) {
        this.setState({[e.target.name]: e.target.value});
    }

    private handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();

        const data = {
            districtName: this.state.districtName,
            numberOfVDCs: this.state.numberOfVDCs,
            numberOfMunicipalities: this.state.numberOfMunicipalities
        };

        const headers = {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        };

        fetch(
            'http://localhost:9090/district/add',
            {
                method: 'POST',
                body: JSON.stringify(data),
                headers: headers
            }
        )
            .then(res => res.json())
            .then((result) => console.log(result))
    }
}

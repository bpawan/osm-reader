import * as React from 'react';
import {connect} from "react-redux";
import {fetchDistricts} from '../../actions/discritcAction';
import {District, DistrictDataProps} from "../../actions/types";

class DistrictData extends React.Component<any> {
    static handleEdit(e: React.MouseEvent<HTMLTableCellElement, MouseEvent>): void {
        e.preventDefault();
    }

    componentWillMount(): void {
        this.props.fetchDistricts();
    }

    render(): React.ReactNode {
        if (undefined !== this.props.districts) {
            const districtItems = this.props.districts.items.map((district: District) => {
                return (<tr key={district.id}>
                    <th scope="row">{district.id}</th>
                    <td>{district.name}</td>
                    <td>{district.numberOfVDCs}</td>
                    <td>{district.numberOfMunicipalities}</td>
                    <td onClick={DistrictData.handleEdit}>add</td>
                </tr>);
            });
            return <table className="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">VDCs</th>
                    <th scope="col">Municipalities</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>{districtItems}</tbody>
            </table>
        }
        return <div>No data to display.</div>
    }
}

const mapStateToProps = function (state: DistrictDataProps) {
    return {districts: state.districts};
};

export default connect(mapStateToProps, {fetchDistricts})(DistrictData);

/* globals fetch:false */
/* globals console:false */

import React from 'react';
import { Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn } from 'material-ui/Table';
import { cyan300 } from 'material-ui/styles/colors.js';
require('../css/kino.scss');

export default class KinoTable extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      lkd: {
        id: '',
        draw: {
          drawTime: '',
          drawNo: '',
          results: []
        }
      }
    };
  }

  componentDidMount() {
    fetch(this.props.source)
      .then(response => response.json())
      .then(lkd => {
        this.setState({ lkd });
      })
      .catch(error => { console.log(error); });
  }

  render() {
    const styles = { backgroundColor: cyan300 };

    // 10 x 8 table
    const rows = Array.from(Array(10), (x, i) => {
      return (
        <TableRow key={i}>
        {Array.from(new Array(8), (y, j) => {
          const cell = j + 1 + i * 8;
          return this.state.lkd.draw.results.includes(cell)
            ? <TableRowColumn key={j} className={'draw-selected'}>{cell}</TableRowColumn>
            : <TableRowColumn key={j}>{cell}</TableRowColumn>;
        })}
        </TableRow>
      );
    });

    return (
      <Table selectable={this.props.selectable}>
        <TableHeader displaySelectAll={this.props.displaySelectAll}>
          <TableRow>
            <TableHeaderColumn colSpan="2">
              Ημερομηνία: {this.state.lkd.draw.drawTime}
            </TableHeaderColumn>
            <TableHeaderColumn colSpan="2">
              Κλήρωση: {this.state.lkd.draw.drawNo}
            </TableHeaderColumn>
          </TableRow>
        </TableHeader>
        <TableBody displayRowCheckbox={this.props.displayRowCheckbox}>
        {rows}
        </TableBody>
      </Table>
    );
  }
}

KinoTable.propTypes = { source: React.PropTypes.string };
KinoTable.defaultProps = { selectable: false, displayRowCheckbox: false, displaySelectAll: false };

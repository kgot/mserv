/* globals console:false */
/* globals document:false */

import React from 'react';
import ReactDOM from 'react-dom';
import KinoTable from './kinoTab';
import My from './my';
import { Card, CardTitle } from 'material-ui/Card';
import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MenuItem from 'material-ui/MenuItem';
import MoreVertIcon from 'material-ui/svg-icons/navigation/more-vert';
import NavigationClose from 'material-ui/svg-icons/navigation/close';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';


ReactDOM.render(
  <MuiThemeProvider muiTheme={getMuiTheme()}>
    <AppBar
      title="OPAP Games"
      iconElementRight={
        <IconMenu
          iconButtonElement={<IconButton><MoreVertIcon /></IconButton>}
          targetOrigin={{ horizontal: 'right', vertical: 'top' }}
          anchorOrigin={{ horizontal: 'right', vertical: 'top' }}>
          <MenuItem primaryText="Help Me!" />
        </IconMenu>
      }/>
    </MuiThemeProvider>,
  document.getElementById('appbar')
);

ReactDOM.render(
  <MuiThemeProvider muiTheme={getMuiTheme()}>
    <Card>
      <CardTitle title="Kino Table" />
      <KinoTable source="/kinodraws/last" />
    </Card>
  </MuiThemeProvider>,
  document.getElementById('kinotable')
);

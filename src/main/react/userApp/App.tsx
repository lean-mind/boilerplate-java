import React from 'react'
import {render} from 'react-dom'
import {UserComponent} from './UserComponent';
import {createClient} from '../infrastructure/client';

render(<UserComponent
        client={createClient("http://localhost:8080")}
        props={this.props}></UserComponent>,
    document.querySelector('#UserApp'));
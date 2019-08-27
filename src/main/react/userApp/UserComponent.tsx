import React, {useEffect, useState} from 'react';
import {messages, translate} from "../infrastructure/messages";

declare global {
    interface Window {
        _appData: any;
    }
}


function UserComponent({ client, props }) {
    window._appData = window._appData || {};
    props = props || {};

    if (window._appData.user) {
        props.user = window._appData.user;
    }

    const [pet, setPet] = useState("");

    const onNameChange = async (event) => {
        setPet(event.target.value);
    };
    
    function onClickHandler() {
        client.addPet(
            pet,
            props.user.id
        ).then(id => {
            location.reload()
        });
    }

    function objectIsEmpty(object: Object) {
        return JSON.stringify(object) == "{}"
    }

    return (
        <div className="card">
            <div className="card-content vh70">
                <span className="card-title">{props.user.name}</span>
                <div className="info">
                    <h2>Añadir pet</h2>
                    <input name="pet" onChange={onNameChange} />
                    <button onClick={onClickHandler}>Añadir</button>
                    <hr />
                    <h2>Mis pets ({props.user.pets.length})</h2>
                    <div className="row">
                        {props.user.pets.map((pet, i) => 
                            <div className="col s6 m3" key={i}>{pet.name} (N{i+1})</div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    )
}

function objectIsEmpty(object: Object) {
    return JSON.stringify(object) == "{}"
}

export {UserComponent};
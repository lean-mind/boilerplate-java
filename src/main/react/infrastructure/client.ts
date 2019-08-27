import {ServerError} from "./serverError";

let createClient = (baseUrl) => {

    const addPet = async (name: String, userId: Number) => {
        return fetch(baseUrl + '/api/pets', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ 
                name, userId
            })
        }).then(response => {
            if (!response.ok) {
                throw new ServerError(String(response.status))
            }
            return response.json();
        });
    };

    return {addPet}
};

export {createClient};
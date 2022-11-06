import { getUserData } from './session.js';
export function get(url) {
    return newRequest(url, 'get');
}

export function post(url, data) {
    return newRequest(url, 'post', data);
}

export function put(url, data){
    return newRequest(url, 'put', data);
}

export function del(url, data){
    return newRequest(url, 'delete', data);
}

async function newRequest(url, method, data) {
    const host = 'http://localhost:3030';
    const userData = getUserData();

    const options = {
        method,
        headers: {}
    };

    if (data != undefined) {
        options.body = JSON.stringify(data);
        options.headers['Content-Type'] = 'application/json';
    };

    if (userData != null) {
        options.headers['X-Authorization'] = userData.accessToken;
    }

    try {
        const response = await fetch(host + url, options);

        if (response.ok == false) {

            const error = await response.json();
            throw new Error(error.message);
        }


        if(response.status == 204){
            return response;
        }
        
        return response.json();

    } catch (error) {
        throw error;
    }
};
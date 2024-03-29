import { get, post } from './request.js';
import { page } from './lib.js';
import { clearUserData, setUserData } from './session.js';
import { update } from './views.js';

export async function login(email, password) {
    try {
        const data = { email, password };

        if (email == '' || password == '') {
            throw new Error('Fields cannot be empty!')
        }
        const response = await post('/users/login', data);

        setUserData(response);

        page.redirect('/dashboard');
        update();
    } catch (error) {
        alert(error.message);
    }
}

export async function register(email, password) {
    try {
        const data = { email, password };

        if (email == '' || password == '') {
            throw new Error('Fields cannot be empty!')
        }
        const response = await post('/users/register', data);

        setUserData(response);

        page.redirect('/dashboard');
        update();
    } catch (error) {
        alert(error.message);
    }
}

export async function logout() {
    try {
        await get('/users/logout');

        clearUserData();

        page.redirect('/dashboard');

        update();
    } catch (error) {
        alert(error.message);
    }
}


import { get, post } from './request.js';
import { page } from './lib.js';
import { clearUserData, setUserData } from './session.js';
import { update } from './views.js';

export async function login(options) {
    try {

        if(Object.entries(options).some(a=>a[1]=='')){
            throw new Error('You have empty fields!');
        }
        const response = await post('/users/login', options);

        setUserData(response);

        page.redirect('/dashboard');
        update();
    } catch (error) {
        alert(error.message);
    }
}

export async function register(options) {
    try {

        if(Object.entries(options).some(a=>a[1]=='')){
            throw new Error('You have empty fields!');
        }
        const response = await post('/users/register', options);

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
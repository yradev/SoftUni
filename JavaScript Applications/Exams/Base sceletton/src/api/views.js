import { loginView } from '../views/login.js';
import { getUserData } from './session.js';
import { registerView } from '../views/register.js';
import { logout } from './auth.js';

export const views = {
    home() {  },
    login() { loginView(); },
    logout() { logout(); },
    register() { registerView(); }
}

export const accessibility = {
    guest() {
        document.querySelector('#user').style.display = 'none';
        document.querySelector('#guest').style.display = '';
    },
    loggedUser() {
        document.querySelector('#user').style.display = '';
        document.querySelector('#guest').style.display = 'none';
    }
}

export function update() {
    if (getUserData() == null) {
        accessibility.guest();
    } else {
        accessibility.loggedUser();
    }
}
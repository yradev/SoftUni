import { loginView } from '../views/loginView.js';
import { getUserData } from './session.js';
import { registerView } from '../views/registerView.js';
import { logout } from './auth.js';
import { homeView } from '../views/homeView.js';
import { dashboardView } from '../views/dashboardView.js';
import { createPageView } from '../views/createPageView.js';

export const views = {

    home: () => homeView(),
    login: () => loginView(),
    logout: () => logout(),
    register: () => registerView(),
    dashboard: () => dashboardView(),
    addAlbum: () => createPageView()
}

export const accessibility = {
    guest() {
        document.querySelector('.user').style.display = 'none';
        document.querySelector('.guest').style.display = '';
    },
    loggedUser() {
        document.querySelector('.user').style.display = '';
        document.querySelector('.guest').style.display = 'none';
    }
}

export function update() {
    if (getUserData() == null) {
        accessibility.guest();
    } else {
        accessibility.loggedUser();
    }
}
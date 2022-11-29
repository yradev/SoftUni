import { loginView } from '../views/login.js';
import { getUserData } from './session.js';
import { registerView } from '../views/register.js';
import { logout } from './auth.js';
import { homeView } from '../views/homeView.js';
import { dashboardView } from '../views/dashboard.js';
import { createPageView } from '../views/createPage.js';
import { searchView } from '../views/searchPage.js';

export const views = {
    home() { homeView(); },
    login() { loginView(); },
    logout() { logout(); },
    register() { registerView(); },
    dashboard() { dashboardView(); },
    createPage() { createPageView() },
    search() { searchView() },


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
import { loginView } from '../views/login.js';
import { getUserData } from './session.js';
import { registerView } from '../views/register.js';
import { logout } from './auth.js';
import { homeView } from '../views/homeView.js';
import { dashboardView } from '../views/dashboardView.js';
import { createPageView } from '../views/createPageView.js';
import { detailsPageView } from '../views/detailsPage.js';

export const views = {
    home() { homeView(); },
    login() { loginView(); },
    logout() { logout(); },
    register() { registerView(); },
    dashboard() { dashboardView(); },
    createPostcard() { createPageView(); },
    petDetails(data) { detailsPageView(data); }



}

export const accessibility = {
    guest() {
        document.querySelectorAll('.user').forEach(a => a.style.display = 'none');
        document.querySelectorAll('.guest').forEach(a => a.style.display = '');
    },
    loggedUser() {
        document.querySelectorAll('.user').forEach(a => a.style.display = '');
        document.querySelectorAll('.guest').forEach(a => a.style.display = 'none');
    }
}

export function update() {
    if (getUserData() == null) {
        accessibility.guest();
    } else {
        accessibility.loggedUser();
    }
}
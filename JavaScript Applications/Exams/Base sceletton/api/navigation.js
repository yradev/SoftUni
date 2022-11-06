import { render as oldRender } from '../api/lib.js';
import { template as dashboardView } from '../src/views/dashboard.js';
import { loginView } from '../src/views/login.js';
import { clearUserData, getUserData } from './session.js';
import { registerView } from '../src/views/register.js';



function render(view) {
    oldRender(view, document.querySelector('#main-content'));
}

export const views = {
    home() { return render(dashboardView()) },
    login() { loginView(); },
    logout() { clearUserData(); update(); },
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
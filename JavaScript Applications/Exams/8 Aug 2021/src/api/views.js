import { loginView } from '../views/loginView.js';
import { getUserData } from './session.js';
import { registerView } from '../views/registerView.js';
import { logout } from './auth.js';
import { dashboardView } from '../views/dashboardView.js';
import { myBooksView } from '../views/myBooks.js';
import { createPageView } from '../views/createPage.js';

export const views = {

    home: () => dashboardView(),
    login: () => loginView(),
    logout: () => logout(),
    register: () => registerView(),
    mybooks: () => myBooksView(),
    addBooks: () => createPageView()
}

export const accessibility = {
    guest() {
        document.querySelector('#user').style.display = 'none';
        document.querySelector('#guest').style.display = '';
    },
    loggedUser() {
        const username = getUserData().email;
        document.querySelector('#user').style.display = '';
        document.querySelector('#guest').style.display = 'none';
        document.querySelector('#welcome').textContent= `Welcome, ${username}`;
    }
}

export function update() {
    if (getUserData() == null) {
        accessibility.guest();
    } else {
        accessibility.loggedUser();
    }
}
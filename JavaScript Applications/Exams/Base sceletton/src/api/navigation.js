import { render as oldRender } from '../api/lib.js';
import { dashboardView, detailsView } from '../views/dashboard.js';
import { loginView } from '../views/login.js';
import { clearUserData, getUserData } from './session.js';
import { registerView } from '../views/register.js';
import { createPostView } from '../views/createPost.js';
import { detailsEdit } from '../views/editPage.js';
import { myPostsView } from '../views/myPosts.js';
import { logout } from './auth.js';



function render(view) {
    oldRender(view, document.querySelector('#main-content'));
}

export const views = {
    home() { dashboardView() },
    login() { loginView(); },
    logout() { logout(); update(); },
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
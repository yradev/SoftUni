import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';


const template = () => html`
<section id="login-page" class="auth">
    <form id="login">
        <h1 class="title">Login</h1>

        <article class="input-group">
            <label for="login-email">Email: </label>
            <input type="email" id="login-email" name="email">
        </article>

        <article class="input-group">
            <label for="password">Password: </label>
            <input type="password" id="password" name="password">
        </article>

        <input type="submit" class="btn submit-btn" value="Log In">
    </form>
</section>`;

export function loginView(){
    render(template(),document.querySelector('#main-content'));

    document.querySelector('#login').addEventListener('submit',(event)=>{
        event.preventDefault();

        const formData = new FormData(event.target);

        const email = formData.get('email');
        const password = formData.get('password');

        login(email,password);
    });
};
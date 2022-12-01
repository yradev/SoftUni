import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';


const template = () => html`
<!-- Login Page ( Only for Guest users ) -->
<section id="login-page" class="auth">
            <form id="login">

                <div class="container">
                    <div class="brand-logo"></div>
                    <h1>Login</h1>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="Sokka@gmail.com">

                    <label for="login-pass">Password:</label>
                    <input type="password" id="login-password" name="password">
                    <input type="submit" class="btn submit" value="Login">
                    <p class="field">
                        <span>If you don't have profile click <a href="/register">here</a></span>
                    </p>
                </div>
            </form>
        </section>
`;

export function loginView(){
    render(template(),document.querySelector('#main-content'));

    document.querySelector('#login').addEventListener('submit',(event)=>{
        event.preventDefault();

        const formData = new FormData(event.target);

        const options = {};
        for (const data of formData.entries()) {
            options[data[0]] = data[1];
        }

        login(options);
    });
};
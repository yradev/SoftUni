import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';


const template = () => html`

<section id="loginPage">
            <form class="loginForm">
                <img src="./images/logo.png" alt="logo" />
                <h2>Login</h2>

                <div>
                    <label for="email">Email:</label>
                    <input id="email" name="email" type="text" placeholder="steven@abv.bg" value="">
                </div>

                <div>
                    <label for="password">Password:</label>
                    <input id="password" name="password" type="password" placeholder="********" value="">
                </div>

                <button class="btn" type="submit">Login</button>

                <p class="field">
                    <span>If you don't have profile click <a href="/register">here</a></span>
                </p>
            </form>
        </section>
`;

export function loginView(){
    render(template(),document.querySelector('#content'));

    document.querySelector('.loginForm').addEventListener('submit',(event)=>{
        event.preventDefault();

        const formData = new FormData(event.target);

        const email = formData.get('email');
        const password = formData.get('password');

        login(email,password);
    });
};
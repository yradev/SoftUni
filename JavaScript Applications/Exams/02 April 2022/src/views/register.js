import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';

const template = () => html`
<!--Register Page-->
<section id="registerPage">
            <form class="registerForm">
                <img src="./images/logo.png" alt="logo" />
                <h2>Register</h2>
                <div class="on-dark">
                    <label for="email">Email:</label>
                    <input id="email" name="email" type="text" placeholder="steven@abv.bg" value="">
                </div>

                <div class="on-dark">
                    <label for="password">Password:</label>
                    <input id="password" name="password" type="password" placeholder="********" value="">
                </div>

                <div class="on-dark">
                    <label for="repeatPassword">Repeat Password:</label>
                    <input id="repeatPassword" name="repeatPassword" type="password" placeholder="********" value="">
                </div>

                <button class="btn" type="submit">Register</button>

                <p class="field">
                    <span>If you have profile click <a href="/login">here</a></span>
                </p>
            </form>
        </section>
`;

export function registerView() {
    render(template(), document.querySelector('#content'));

    document.querySelector('.registerForm').addEventListener('submit', (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);

        const email = formData.get('email');
        const password = formData.get('password');
        const confirmPassword = formData.get('repeatPassword');

        if(password!=confirmPassword){
            alert('Passwords are not equal');
        }else{
            register(email,password);
        }
    });
}
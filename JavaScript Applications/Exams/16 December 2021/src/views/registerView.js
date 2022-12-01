import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';
import { getOptionsFromForms } from '../api/utill.js';


const template = () => html`
 <!--Register Page-->
 <section id="registerPage">
            <form class="registerForm">
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
                    <span>If you have profile click <a href="#">here</a></span>
                </p>
            </form>
        </section>
`;

export function registerView() {
    render(template(), document.querySelector('#content'));

    document.querySelector('.registerForm').addEventListener('submit', (event) => {
        event.preventDefault();

        const options = getOptionsFromForms(event.target);

        if(options['password']!=options['repeatPassword']){
            alert('Passwords are not equal');
        }else{
            register(options);
        }
    });
};
import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';
import { getOptionsFromForms } from '../api/utill.js';


const template = () => html`
 <!--Login Page-->
 <section id="loginaPage">
            <form class="loginForm">
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
                    <span>If you don't have profile click <a href="#">here</a></span>
                </p>
            </form>
        </section>
`;

export function loginView(){
    render(template(),document.querySelector('#content'));

    document.querySelector('.loginForm').addEventListener('submit',(event)=>{
        event.preventDefault();

        login(getOptionsFromForms(event.target));
    });
};
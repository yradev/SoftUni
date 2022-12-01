import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';


const template = () => html`

        <!-- Login Page ( Only for Guest users ) -->
        <section id="login-page" class="login">
            <form id="login-form" action="" method="">
                <fieldset>
                    <legend>Login Form</legend>
                    <p class="field">
                        <label for="email">Email</label>
                        <span class="input">
                            <input type="text" name="email" id="email" placeholder="Email">
                        </span>
                    </p>
                    <p class="field">
                        <label for="password">Password</label>
                        <span class="input">
                            <input type="password" name="password" id="password" placeholder="Password">
                        </span>
                    </p>
                    <input class="button submit" type="submit" value="Login">
                </fieldset>
            </form>
        </section>
`;

export function loginView(){
    render(template(),document.querySelector('#site-content'));

    document.querySelector('#login-form').addEventListener('submit',(event)=>{
        event.preventDefault();

        const formData = new FormData(event.target);

        const options = {};
        for (const data of formData.entries()) {
            options[data[0]] = data[1];
        }

        login(options);
    });
};
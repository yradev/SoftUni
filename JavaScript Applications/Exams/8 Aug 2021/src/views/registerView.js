import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';

const template = () => html`
<!-- Register Page ( Only for Guest users ) -->
<section id="register-page" class="register">
            <form id="register-form" action="" method="">
                <fieldset>
                    <legend>Register Form</legend>
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
                    <p class="field">
                        <label for="repeat-pass">Repeat Password</label>
                        <span class="input">
                            <input type="password" name="confirm-pass" id="repeat-pass" placeholder="Repeat Password">
                        </span>
                    </p>
                    <input class="button submit" type="submit" value="Register">
                </fieldset>
            </form>
        </section>
`;

export function registerView() {
    render(template(), document.querySelector('#site-content'));

    document.querySelector('#register-form').addEventListener('submit', (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);

        const options = {};
        for (const data of formData.entries()) {
            options[data[0]] = data[1];
        }

        if(options['password']!=options['confirm-pass']){
            alert('Passwords are not equal');
        }else{
            register(options);
        }
    });
};
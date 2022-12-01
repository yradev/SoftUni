import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';

const template = () => html`
  <!-- Register Page ( Only for Guest users ) -->
  <section id="register-page" class="content auth">
            <form id="register">
                <div class="container">
                    <div class="brand-logo"></div>
                    <h1>Register</h1>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="maria@email.com">

                    <label for="pass">Password:</label>
                    <input type="password" name="password" id="register-password">

                    <label for="con-pass">Confirm Password:</label>
                    <input type="password" name="confirm-password" id="confirm-password">

                    <input class="btn submit" type="submit" value="Register">

                    <p class="field">
                        <span>If you already have profile click <a href="/login">here</a></span>
                    </p>
                </div>
            </form>
        </section>
`;

export function registerView() {
    render(template(), document.querySelector('#main-content'));

    document.querySelector('#register').addEventListener('submit', (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);

        const options = {};
        for (const data of formData.entries()) {
            options[data[0]] = data[1];
        }

        if(options['password']!=options['confirm-password']){
            alert('Passwords are not equal');
        }else{
            register(options);
        }
    });
}
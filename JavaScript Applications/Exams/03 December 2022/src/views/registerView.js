import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';
import { getOptionsFromForms } from '../api/utill.js';

const template = () => html`
      <!-- Register Page (Only for Guest users) -->
      <section id="register">
        <div class="form">
          <h2>Register</h2>
          <form class="login-form">
            <input type="text" name="email" id="register-email" placeholder="email" />
            <input type="password" name="password" id="register-password" placeholder="password" />
            <input type="password" name="re-password" id="repeat-password" placeholder="repeat password" />
            <button type="submit">register</button>
            <p class="message">Already registered? <a href="#">Login</a></p>
          </form>
        </div>
      </section>
`;

export function registerView() {
    render(template(), document.querySelector('main'));

    document.querySelector('.login-form').addEventListener('submit', (event) => {
        event.preventDefault();

        const options = getOptionsFromForms(event.target);

        if(options['password']!=options['re-password']){
            alert('Passwords are not equal');
        }else{
            register(options);
        }
    });
};
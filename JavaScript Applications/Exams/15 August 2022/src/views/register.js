import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';

const template = () => html`
<!-- Register Page (Only for Guest users) -->
<section id="register">
          <div class="form">
            <h2>Register</h2>
            <form class="login-form">
              <input
                type="text"
                name="email"
                id="register-email"
                placeholder="email"
              />
              <input
                type="password"
                name="password"
                id="register-password"
                placeholder="password"
              />
              <input
                type="password"
                name="re-password"
                id="repeat-password"
                placeholder="repeat password"
              />
              <button type="submit">login</button>
              <p class="message">Already registered? <a href="/login">Login</a></p>
            </form>
          </div>
        </section>
`;

export function registerView() {
    render(template(), document.querySelector('main'));

    document.querySelector('#register').addEventListener('submit', (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);

        const email = formData.get('email');
        const password = formData.get('password');
        const confirmPassword = formData.get('re-password');

        if(password!=confirmPassword){
            alert('Passwords are not equal');
        }else{
            register(email,password);
        }
    });
}
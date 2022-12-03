import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';
import { getOptionsFromForms } from '../api/utill.js';


const template = () => html`
 <!-- Login Page (Only for Guest users) -->
 <section id="login">
        <div class="form">
          <h2>Login</h2>
          <form class="login-form">
            <input type="text" name="email" id="email" placeholder="email" />
            <input type="password" name="password" id="password" placeholder="password" />
            <button type="submit">login</button>
            <p class="message">
              Not registered? <a href="#">Create an account</a>
            </p>
          </form>
        </div>
      </section>
`;

export function loginView(){
    render(template(),document.querySelector('main'));

    document.querySelector('.login-form').addEventListener('submit',(event)=>{
        event.preventDefault();

        login(getOptionsFromForms(event.target));
    });
};
import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';

const template = () => html`

        <!-- Register Page (Only for Guest users) -->
        <section id="register-page" class="auth">
            <form id="register">
                <h1 class="title">Register</h1>
        
                <article class="input-group">
                    <label for="register-email">Email: </label>
                    <input type="email" id="register-email" name="email">
                </article>
        
                <article class="input-group">
                    <label for="register-password">Password: </label>
                    <input type="password" id="register-password" name="password">
                </article>
        
                <article class="input-group">
                    <label for="repeat-password">Repeat Password: </label>
                    <input type="password" id="repeat-password" name="repeatPassword">
                </article>
        
                <input type="submit" class="btn submit-btn" value="Register">
            </form>
        </section>

`;

export function registerView() {
    render(template(), document.querySelector('#main-content'));

    document.querySelector('#register').addEventListener('submit', (event) => {
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
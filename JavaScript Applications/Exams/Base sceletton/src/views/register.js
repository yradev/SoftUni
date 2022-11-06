import { html, render } from '../api/lib.js';
import { register } from '../api/auth.js';

const template = () => html`
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
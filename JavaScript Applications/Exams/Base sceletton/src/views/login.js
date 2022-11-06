import { html, render } from '../api/lib.js';
import { login } from '../api/auth.js';


const template = () => html`
`;

export function loginView(){
    render(template(),document.querySelector('#main-content'));

    document.querySelector('#login').addEventListener('submit',(event)=>{
        event.preventDefault();

        const formData = new FormData(event.target);

        const email = formData.get('email');
        const password = formData.get('password');

        login(email,password);
    });
};
import { html, render } from '../api/lib.js';


const template = () => html`
`;

export function loginView(){
    render(template(),document.querySelector('#content'));
};
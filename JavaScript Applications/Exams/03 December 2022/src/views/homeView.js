import { html, render } from '../api/lib.js';


const template = () => html`
<section id="home">
        <img src="./images/landing.png" alt="home" />

        <h2 id="landing-text"><span>Add your favourite albums</span> <strong>||</strong> <span>Discover new ones right
            here!</span></h2>
      </section>
`;

export function homeView(){
    render(template(),document.querySelector('main'));
};
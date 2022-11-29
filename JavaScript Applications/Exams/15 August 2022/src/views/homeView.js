import { html, render } from '../api/lib.js';


const template = () => html`
 <!-- Home page -->
 <section id="home">
          <h1>Welcome to Sole Mates</h1>
          <img src="./images/home.jpg" alt="home" />
          <h2>Browse through the shoe collectibles of our users</h2>
          <h3>Add or manage your items</h3>
        </section>
`;

export function homeView(){
    render(template(),document.querySelector('main'));
};
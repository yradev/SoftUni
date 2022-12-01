import { getEvents } from '../api/events.js';
import { html, render } from '../api/lib.js';
import { detailsView } from './detailsView.js';


const template = () => html`
<!--Home Page-->
<section class="welcomePage">
    <div id="welcomeMessage">
        <h1>My Theater</h1>
        <p>Since 1962 World Theatre Day has been celebrated by ITI Centres, ITI Cooperating Members, theatre
            professionals, theatre organizations, theatre universities and theatre lovers all over the world on
            the 27th of March. This day is a celebration for those who can see the value and importance of the
            art
            form “theatre”, and acts as a wake-up-call for governments, politicians and institutions which have
            not
            yet recognised its value to the people and to the individual and have not yet realised its potential
            for
            economic growth.</p>
    </div>
    <div id="events">
        <h1>Future Events</h1>
        <div class="theaters-container">
        </div>
    </div>
</section>
`;


const newEvent = (imageUrl, title, date, author) => html`
    <div class="home-image">
        <img src="${imageUrl}">
    </div>
    <div class="info">
        <h4 class="title">${title}</h4>
        <h6 class="date">${date}</h6>
        <h6 class="author">${author}</h6>
        <div class="info-buttons">
            <a class="btn-details" href="javascript:void(0)">Details</a>
        </div>
    </div>
`;
export async function homeView() {
    render(template(), document.querySelector('#content'));

    const allEvents = await getEvents();

    const theatersContainer = document.querySelector('.theaters-container');
    theatersContainer.innerHTML = '';

    if (allEvents.length > 0) {
        allEvents.forEach(a => {
            const div = document.createElement('div');
            div.className = 'eventsInfo';
            render(newEvent(a.imageUrl, a.title, a.date, a.author), div);
            theatersContainer.appendChild(div);

            div.querySelector('.btn-details').addEventListener('click', () => detailsView(a._id));
        });
    } else {
        const h4 = document.createElement('h4');
        h4.className = 'no-event';
        h4.textContent = 'No Events Yet...';

        theatersContainer.appendChild(h4);
    }

};
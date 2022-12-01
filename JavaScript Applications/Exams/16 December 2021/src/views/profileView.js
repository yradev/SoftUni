import { getMyEvents } from '../api/events.js';
import { html, render } from '../api/lib.js';
import { getUserData } from '../api/session.js';
import { detailsView } from './detailsView.js';


const template = (email) => html`
<!--Profile Page-->
<section id="profilePage">
    <div class="userInfo">
        <div class="avatar">
            <img src="./images/profilePic.png">
        </div>
        <h2>${email}</h2>
    </div>
    <div class="board"></div>
</section>
`;

const newEvent = (imageUrl,title,date) => html`
<div class="eventBoard">
    <div class="event-info">
        <img src="${imageUrl}">
        <h2>${title}</h2>
        <h6>${date}</h6>
        <a href="javascript:void(0)" class="details-button">Details</a>
    </div>
</div>
`;
export async function profileView() {
    const email = getUserData().email;
    render(template(email), document.querySelector('#content'));

    const myEvents = await getMyEvents();

    const board = document.querySelector('.board');
    board.innerHTML = '';


    if (myEvents.length > 0) {
        myEvents.forEach(a=>{
           const div = document.createElement('div');
           div.className='eventInfo';
           render(newEvent(a.imageUrl,a.title,a.date,a.authro),div);
           board.appendChild(div);

           div.querySelector('.details-button').addEventListener('click',()=>detailsView(a._id));
           board.appendChild(div);
           
        });
    } else {
        const div = document.createElement('div');
        div.className = 'no-events';

        const p = document.createElement('p');
        p.textContent = 'This user has no events yet!';

        div.appendChild(p);
        board.appendChild(div);
    }
};
import { addLike, deleteEvent, getEventById, getLikes, isLikedByMe } from '../api/events.js';
import { html, page, render } from '../api/lib.js';
import { amICreator, getUserData } from '../api/session.js';
import { editPageView } from './editPageView.js';


const template = (title, imageUrl, description, date, author, likes) => html`
<!--Details Page-->
<section id="detailsPage">
    <div id="detailsBox">
        <div class="detailsInfo">
            <h1>Title: ${title}</h1>
            <div>
                <img src="${imageUrl}" />
            </div>
        </div>

        <div class="details">
            <h3>Theater Description</h3>
            <p>${description}</p>
            <h4>Date: ${date}</h4>
            <h4>Author: ${author}</h4>
            <div class="buttons">

            </div>
            <p class="likes">Likes: ${likes}</p>
        </div>
    </div>
</section>
`;

const creatorButtons = () => html`
<a class="btn-delete" href="javascript:void(0)">Delete</a>
<a class="btn-edit" href="javascript:void(0)">Edit</a>
`;

export async function detailsView(id) {
    const likes = await getLikes(id);
    const eventDetails = await getEventById(id);
    render(template(eventDetails.title, eventDetails.imageUrl, eventDetails.description, eventDetails.date, eventDetails.author, likes), document.querySelector('#content'));

    const buttons = document.querySelector('.buttons')
    if (getUserData() != null) {
        if (amICreator(eventDetails._ownerId)) {
            const div = document.createElement('div');

            render(creatorButtons(), div);

            buttons.appendChild(div);

            div.querySelector('.btn-edit').addEventListener('click', () => editPageView(eventDetails));
            div.querySelector('.btn-delete').addEventListener('click', () => {
                if (confirm('Press ok to delete this event!')) {
                    deleteEvent(eventDetails._id);
                }
            });
        } else {
            const isLiked = await isLikedByMe(eventDetails._id);
            if (!isLiked) {
                const a = document.createElement('a');
                a.className = 'btn-like';
                a.href = 'javascript:void(0)';
                a.textContent = 'Like';

                buttons.appendChild(a);

                a.addEventListener('click', () => {
                    addLike(eventDetails._id);
                    a.remove();
                    detailsView(eventDetails._id);
                })
            }
        }
    }

};
import { amILiked, deleteBook, getBookDetails, getLikes, newLike } from '../api/book.js';
import { html, page, render } from '../api/lib.js';
import { amICreator, getUserData } from '../api/session.js';
import { editPageView } from './editPage.js';


const template = (title, type, imageUrl, likes, description) => html`
<!-- Details Page ( for Guests and Users ) -->
<section id="details-page" class="details">
    <div class="book-information">
        <h3>${title}</h3>
        <p class="type">Type: ${type}</p>
        <p class="img"><img src="${imageUrl}"></p>
        <div class="actions">
            <!-- Edit/Delete buttons ( Only for creator of this book )  -->

            <!-- Bonus -->
            <!-- Like button ( Only for logged-in users, which is not creators of the current book ) -->

            <!-- ( for Guests and Users )  -->
            <div class="likes">
                <img class="hearts" src="/images/heart.png">
                <span id="total-likes">Likes: ${likes}</span>
            </div>
            <!-- Bonus -->
        </div>
    </div>
    <div class="book-description">
        <h3>Description:</h3>
        <p>${description}</p>
    </div>
</section>
`;

const buttons = () => html`
<a class="button" id='edit-btn' href="javascript:void(0)">Edit</a>
<a class="button" id='delete-btn' href="javascript:void(0)">Delete</a>
`;
export async function detailsView(id) {

    const likes = await getLikes(id);
    const bookDetails = await getBookDetails(id);

    render(template(bookDetails.title, bookDetails.type, bookDetails.imageUrl, likes, bookDetails.description), document.querySelector('#site-content'));
    const actions = document.querySelector('.actions');

    if (getUserData() != null) {
        if (amICreator(bookDetails._ownerId)) {
            const div = document.createElement('div');
            render(buttons(), div);
            actions.appendChild(div);
            actions.querySelector('#edit-btn').addEventListener('click', () => editPageView(bookDetails));
            actions.querySelector('#delete-btn').addEventListener('click', () => {
                if (confirm('Press ok to delete this book!')) {
                    deleteBook(id);
                }
            });

        } else {
            const liked = await amILiked(id);

            if (!liked) {
                const a = document.createElement('a');
                a.href = 'javascript:void(0)';
                a.className = 'button';
                a.textContent = 'Like';

                actions.appendChild(a);

                a.addEventListener('click', () => {
                    newLike(id);
                    a.remove();
                    detailsView(id);                    
                });
            }
        }
    }

};
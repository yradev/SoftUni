import { createNewComment, deleteGame, getAllComments, getDetailsById } from '../api/game.js';
import { html, render, updateChildrens } from '../api/lib.js';
import { amICreator, getUserData } from '../api/session.js';
import { editPageView } from './editPageView.js';


const template = (imageUrl, title, maxLevel, category, summary) => html`
<!--Details Page-->
<section id="game-details">
    <h1>Game Details</h1>
    <div class="info-section">

        <div class="game-header">
            <img class="game-img" src="${imageUrl}" />
            <h1>${title}</h1>
            <span class="levels">MaxLevel: ${maxLevel}</span>
            <p class="type">${category}</p>
        </div>

        <p class="text">
            ${summary}
        </p>

        <!-- Bonus ( for Guests and Users ) -->
        <div class="details-comments">
            <h2>Comments:</h2>
            <!-- Display paragraph: If there are no games in the database -->
        </div>

        <!-- Edit/Delete buttons ( Only for creator of this game )  -->
    </div>

    <!-- Bonus -->
    <!-- Add Comment ( Only for logged-in users, which is not creators of the current game ) -->

</section>
`;

const createComment = () => html`
    <label>Add new comment:</label>
    <form class="form">
        <textarea id='comment' name="comment" placeholder="Comment......"></textarea>
        <input class="btn submit" type="submit" value="Add Comment">
    </form>
    `;
const buttons = () => html`
<a href="javascript:void(0)" id='edit-btn' class="button">Edit</a>
<a href="javascript:void(0)" id='delete-btn' class="button">Delete</a>
`;

export async function detailsView(id) {
    const game = await getDetailsById(id);

    render(template(game.imageUrl, game.title, game.maxLevel, game.category, game.summary), document.querySelector('#main-content'));

    if (getUserData() != null && amICreator(game._ownerId)) {
        const div = document.createElement('div');
        div.className = 'buttons';
        render(buttons(), div);
        document.querySelector('.info-section').appendChild(div);

        document.querySelector('#edit-btn').addEventListener('click', () => editPageView(game));
        document.querySelector('#delete-btn').addEventListener('click', () => {
            if (confirm('Press ok to delete this game!')) {
                deleteGame(game._id);
            }
        });
    }

    const detailComments = document.querySelector('.details-comments');
    detailComments.removeChild(detailComments.lastChild);

    const allComments = await getAllComments(id);
    if (allComments.length > 0) {
        const ul = document.createElement('ul');

        allComments.forEach(a => {
            const li = document.createElement('li');
            li.className = 'comment';
            const p = document.createElement('p');
            p.textContent = `${a.comment}`;
            li.appendChild(p);
            ul.appendChild(li);
        });

        detailComments.appendChild(ul);
    } else {
        const p = document.createElement('p');
        p.className = 'no-comment';
        p.textContent = 'No comments.';

        detailComments.appendChild(p);
    }

    if (getUserData != null && !amICreator(game._ownerId)) {  
        const gameDetails = document.querySelector('#game-details'); 
        const article = document.createElement('article');
        article.className = 'create-comment';
        render(createComment(), article);
        gameDetails.appendChild(article);

        const form = article.querySelector('.form');
  
        form.addEventListener('submit', (event) => {
            event.preventDefault();
            const formData = new FormData(event.target);

            const options = { gameId: game._id, comment: formData.get('comment') };
            
            createNewComment(options);
            gameDetails.removeChild(gameDetails.lastChild);
        });
    }
};
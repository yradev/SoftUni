import { editGame } from '../api/game.js';
import { html, render } from '../api/lib.js';


const template = (title, category, maxLevel, imageUrl, summary) => html`
<!-- Edit Page ( Only for the creator )-->
<section id="edit-page" class="auth">
    <form id="edit">
        <div class="container">

            <h1>Edit Game</h1>
            <label for="leg-title">Legendary title:</label>
            <input type="text" id="title" name="title" value="${title}">

            <label for="category">Category:</label>
            <input type="text" id="category" name="category" value="${category}">

            <label for="levels">MaxLevel:</label>
            <input type="number" id="maxLevel" name="maxLevel" min="1" value="${maxLevel}">

            <label for="game-img">Image:</label>
            <input type="text" id="imageUrl" name="imageUrl" value="${imageUrl}">

            <label for="summary">Summary:</label>
            <textarea name="summary" id="summary">${summary}</textarea>
            <input class="btn submit" type="submit" value="Edit Game">

        </div>
    </form>
</section>
`;

export function editPageView(game) {
    render(template(game.title, game.category, game.maxLevel, game.imageUrl, game.summary), document.querySelector('#main-content'));

    document.querySelector('#edit').addEventListener('submit', (event) => {
        event.preventDefault();

        const formData = new FormData(event.target);

        const options = {};
        for (const data of formData.entries()) {
            options[data[0]] = data[1];
        }

        editGame(game._id, options);
    });

    

};
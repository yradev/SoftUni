import { getAllGames } from '../api/game.js';
import { html, updateChildrens, render } from '../api/lib.js';
import { detailsView } from './detailsView.js';

const template = () => html`
<!-- Catalogue -->
<section id="catalog-page">
    <h1>All Games</h1>
    <!-- Display div: with information about every game (if any) -->
</section>
`;

const newGame = (imageUrl, category, title) => html`
<div class="allGames">
    <div class="allGames-info">
        <img src="${imageUrl}">
        <h6>${category}</h6>
        <h2>${title}</h2>
        <a href="javascript:void(0)" class="details-button">Details</a>
    </div>
</div>
`;

const noGames = () => html`
    <h3 class="no-articles">No articles yet</h3>
`;

export async function allGamesView() {
    const mainContent = document.querySelector('#main-content');
    render(template(), mainContent);
    const allGames = await getAllGames();
    const catalogPage = document.querySelector('#catalog-page');

    updateChildrens(catalogPage);

    if (allGames.length > 0) {
        allGames.forEach(a=>{
            const div = document.createElement('div');
            render(newGame(a.imageUrl,a.category,a.title),div);
            catalogPage.appendChild(div);

            div.querySelector('.details-button').addEventListener('click',()=>detailsView(a._id));
        }
        );

    } else {
        const div = document.createElement('div');
        render(noGames(),div);
        catalogPage.appendChild(div);
    }
};
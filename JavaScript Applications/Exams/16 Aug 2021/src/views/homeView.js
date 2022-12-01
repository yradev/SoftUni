import { getLastGames } from '../api/game.js';
import { html, updateChildrens, render } from '../api/lib.js';
import { detailsView } from './detailsView.js';


const template = () => html`
<!--Home Page-->
<section id="welcome-world">

    <div class="welcome-message">
        <h2>ALL new games are</h2>
        <h3>Only in GamesPlay</h3>
    </div>
    <img src="./images/four_slider_img01.png" alt="hero">

    <div id="home-page">
        <h1>Latest Games</h1>
    </div>
</section>
`;

const newArticle = (imageUrl, title) => html`
<div class="game">
    <div class="image-wrap">
        <img src="${imageUrl}">
    </div>
    <h3>${title}</h3>
    <div class="rating">
        <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
    </div>
    <div class="data-buttons">
        <a href="javascript:void(0)" id='details-btn' class="btn details-btn">Details</a>
    </div>
</div>
`;

const noArticles = () => `
    <p class="no-articles">No games yet</p>
`;

export async function homeView() {
    render(template(), document.querySelector('#main-content'));
    const homePage = document.querySelector('#home-page');
    const lastGames = await getLastGames();

    updateChildrens(homePage);

    if (lastGames.length > 0) {
        lastGames.forEach(a => {
            const div = document.createElement('div');
            render(newArticle(a.imageUrl, a.title), div);
            homePage.appendChild(div);

            div.querySelector('#details-btn').addEventListener('click', (id) => detailsView(a._id));
        });

    } else {
        const div = document.createElement('div');
        render(noArticles(), div);
        homePage.appendChild(div);
    }
};
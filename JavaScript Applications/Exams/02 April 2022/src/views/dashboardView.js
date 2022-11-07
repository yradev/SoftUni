import { html, render } from '../api/lib.js';
import { getPets } from '../api/pet.js';

const template = () => html`

<section id="dashboard">
    <h2 class="dashboard-title">Services for every animal</h2>
    <div class="animals-dashboard">
        <!--If there is no pets in dashboard-->
        <div id='no-pets'>
        </div>
    </div>
</section>
`;

const newPet = (imageUrl, name, breed, petId) => html`
<div class="animals-board">
    <article class="service-img">
        <img class="animal-image-cover" src="${imageUrl}">
    </article>
    <h2 class="name">${name}</h2>
    <h3 class="breed">${breed}</h3>
    <div class="action">
        <a class="btn" href="/pet/details/${petId}">Details</a>
    </div>
</div>
`;

export async function dashboardView() {
    render(template(), document.querySelector('#content'));

    const pets = await getPets();

    const animalsDashboard = document.querySelector('.animals-dashboard');

    animalsDashboard.innerHTML = '';

    if (pets.length > 0) {
        pets.forEach(a => {
            const div = document.createElement('div');
            div.className = 'animals-board';
            render(newPet(a.image, a.name, a.breed, a._id), div);
            animalsDashboard.append(div);
        });

    }else{
        animalsDashboard.innerHTML = '<p class="no-pets">No pets in dashboard</p>';

    }
};
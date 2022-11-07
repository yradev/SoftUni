import { html, page, render } from '../api/lib.js';
import { addDonation, deletePet, getDonations, getPetById, isUserDonated } from '../api/pet.js';
import { del } from '../api/request.js';
import { getUserData } from '../api/session.js';
import { editPageView } from './editPageView.js';


const template = (image, name, breed, age, weight, donation) => html`
        <section id="detailsPage">
            <div class="details">
                <div class="animalPic">
                    <img src="${image}">
                </div>
                <div id='animalDetails'>
                    <div class="animalInfo">
                        <h1>Name: ${name}</h1>
                        <h3>Breed: ${breed}</h3>
                        <h4>Age: ${age} years</h4>
                        <h4>Weight: ${weight}kg</h4>
                        <h4 class="donation">Donation: ${donation}$</h4>
                    </div>
                </div>
            </div>
        </section>
`;

export async function detailsPageView(data) {
    const petId = data.params.id;
    const pet = await getPetById(petId);
    const donations = await getDonations(petId);

    render(template(pet.image, pet.name, pet.breed, pet.age, pet.weight, donations), document.querySelector('#content'));

    const animalDetails = document.querySelector('#animalDetails');

    if (getUserData != undefined) {
        const div = document.createElement('div');
        div.className = 'actionBtn';

        if (pet._ownerId == getUserData()._id) {
            const editButton = document.createElement('a');
            editButton.href = 'javascript:void(0)';
            editButton.className = 'edit';
            editButton.textContent = 'Edit';

            div.appendChild(editButton);

            const deleteButton = document.createElement('a');
            deleteButton.href = 'javascript:void(0)';
            deleteButton.className = 'delete';
            deleteButton.textContent = 'Delete';

            div.appendChild(deleteButton);


            editButton.addEventListener('click', () => {
                editPageView(petId);
            });

            deleteButton.addEventListener('click', () => {
                if (confirm('Press ok to delete')) {
                    deletePet(petId);
                }
            });

        } else {
            if (await isUserDonated(petId, getUserData()._id) == 0) {

                const donateButton = document.createElement('a');
                donateButton.href = 'javascript:void(0)';
                donateButton.className = 'donate';
                donateButton.textContent = 'Donate';

                div.appendChild(donateButton);

                donateButton.addEventListener('click', () => {
                    addDonation(petId);
                    donateButton.style.display = 'none';
                    page.redirect('/pet/details/'+petId)
                });
            }
        };

        animalDetails.appendChild(div);
    };
};
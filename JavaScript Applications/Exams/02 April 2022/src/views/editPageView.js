import { html, render } from '../api/lib.js';
import { editPet, getPetById } from '../api/pet.js';


const template = (image,name,breed,age,weight) => html`
 <section id="editPage">
            <form class="editForm">
                <img src="${image}">
                <div>
                    <h2>Edit PetPal</h2>
                    <div class="name">
                        <label for="name">Name:</label>
                        <input name="name" id="name" type="text" value="${name}">
                    </div>
                    <div class="breed">
                        <label for="breed">Breed:</label>
                        <input name="breed" id="breed" type="text" value="${breed}">
                    </div>
                    <div class="Age">
                        <label for="age">Age:</label>
                        <input name="age" id="age" type="text" value="${age}">
                    </div>
                    <div class="weight">
                        <label for="weight">Weight:</label>
                        <input name="weight" id="weight" type="text" value="${weight}">
                    </div>
                    <div class="image">
                        <label for="image">Image:</label>
                        <input name="image" id="image" type="text" value="${image}">
                    </div>
                    <button class="btn" type="submit">Edit Pet</button>
                </div>
            </form>
        </section>
`;

export async function editPageView(petId){
    const pet = await getPetById(petId);

    render(template(pet.image,pet.name,pet.breed,pet.age,pet.weight),document.querySelector('#content'));

    document.querySelector('.editForm').addEventListener('submit',(event) =>{
        event.preventDefault();

        const formData = new FormData(event.target);

        editPet(formData,petId);
    })
};
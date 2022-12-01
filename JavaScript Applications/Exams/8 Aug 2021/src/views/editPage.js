import { editBook } from '../api/book.js';
import { html, render } from '../api/lib.js';


const template = (title,description,imageUrl,type) => html`
<!-- Edit Page ( Only for the creator )-->
<section id="edit-page" class="edit">
            <form id="edit-form" action="#" method="">
                <fieldset>
                    <legend>Edit my Book</legend>
                    <p class="field">
                        <label for="title">Title</label>
                        <span class="input">
                            <input type="text" name="title" id="title" value="${title}">
                        </span>
                    </p>
                    <p class="field">
                        <label for="description">Description</label>
                        <span class="input">
                            <textarea name="description"
                                id="description">${description}</textarea>
                        </span>
                    </p>
                    <p class="field">
                        <label for="image">Image</label>
                        <span class="input">
                            <input type="text" name="imageUrl" id="image" value="${imageUrl}">
                        </span>
                    </p>
                    <p class="field">
                        <label for="type">Type</label>
                        <span class="input">
                            <select id="type" name="type" value="${type}">
                                <option value="Fiction" selected>Fiction</option>
                                <option value="Romance">Romance</option>
                                <option value="Mistery">Mistery</option>
                                <option value="Classic">Clasic</option>
                                <option value="Other">Other</option>
                            </select>
                        </span>
                    </p>
                    <input class="button submit" type="submit" value="Save">
                </fieldset>
            </form>
        </section>
`;

export function editPageView(pageDetails){
    render(template(pageDetails.title,pageDetails.description,pageDetails.imageUrl,pageDetails.type),document.querySelector('#site-content'));


    document.querySelector('#edit-form').addEventListener('submit',(event)=>{
        event.preventDefault();

        const formData = new FormData(event.target);

        const options = {};
        for (const data of formData.entries()) {
            options[data[0]] = data[1];
        }

        editBook(options,pageDetails._id);
    });
};
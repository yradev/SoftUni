import { editEvent } from '../api/events.js';
import { html, render } from '../api/lib.js';
import { getOptionsFromForms } from '../api/utill.js';


const template = (title,date,author,description,imageUrl) => html`
<!--Edit Page-->
<section id="editPage">
            <form class="theater-form">
                <h1>Edit Theater</h1>
                <div>
                    <label for="title">Title:</label>
                    <input id="title" name="title" type="text" placeholder="Theater name" value="${title}">
                </div>
                <div>
                    <label for="date">Date:</label>
                    <input id="date" name="date" type="text" placeholder="Month Day, Year" value="${date}">
                </div>
                <div>
                    <label for="author">Author:</label>
                    <input id="author" name="author" type="text" placeholder="Author"
                        value="${author}">
                </div>
                <div>
                    <label for="description">Theater Description:</label>
                    <textarea id="description" name="description"
                        placeholder="Description">${description}</textarea>
                </div>
                <div>
                    <label for="imageUrl">Image url:</label>
                    <input id="imageUrl" name="imageUrl" type="text" placeholder="Image Url"
                        value="${imageUrl}">
                </div>
                <button class="btn" type="submit">Submit</button>
            </form>
        </section>
`;

export function editPageView(details){
    render(template(details.title,details.date,details.author,details.description,details.imageUrl),document.querySelector('#content'));

    document.querySelector('.theater-form').addEventListener('submit',(event)=>{
        event.preventDefault();

        editEvent(getOptionsFromForms(event.target),details._id);
    });
};
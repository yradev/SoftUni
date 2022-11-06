import { html, render } from '../api/lib.js';
import { editPost } from '../api/posts.js';
import { get } from '../api/request.js';

const template = (title,description,imageUrl,address,phone) => html`
<!-- Edit Page (Only for logged-in users) -->
<section id="edit-page" class="auth">
    <form id="edit">
        <h1 class="title">Edit Post</h1>

        <article class="input-group">
            <label for="title">Post Title</label>
            <input type="title" name="title" id="title" value="${title}">
        </article>

        <article class="input-group">
            <label for="description">Description of the needs </label>
            <input type="text" name="description" id="description" value="${description}">
        </article>

        <article class="input-group">
            <label for="imageUrl"> Needed materials image </label>
            <input type="text" name="imageUrl" id="imageUrl" value="${imageUrl}">
        </article>

        <article class="input-group">
            <label for="address">Address of the orphanage</label>
            <input type="text" name="address" id="address" value="${address}">
        </article>

        <article class="input-group">
            <label for="phone">Phone number of orphanage employee</label>
            <input type="text" name="phone" id="phone" value="${phone}">
        </article>

        <input type="submit" class="btn submit" value="Edit Post">
    </form>
</section>
`;

export async function detailsEdit(data) {
    const main = document.querySelector('#main-content');
    const id = data.params.id;

    const itemData =  await get('/data/posts/'+id);
    render(template(itemData.title,itemData.description,itemData.imageUrl,itemData.address,itemData.phone), main);

    main.querySelector('#edit').addEventListener('submit', (event) => {
        event.preventDefault();

        const formData = new FormData(event.target);
        editPost(formData,id);
    });
};

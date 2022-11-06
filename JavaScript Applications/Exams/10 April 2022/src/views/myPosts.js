import { html, render } from '../api/lib.js';
import { getMyPosts } from '../api/posts.js';
import { getUserData } from '../api/session.js';

const template = () => html`
<!-- My Posts -->
<section id="my-posts-page">
    <h1 class="title">My Posts</h1>

    <div class="my-posts" id='myPosts'>
    </div>

    <!-- Display a div with information about every post (if any)-->


    <!-- Display an h1 if there are no posts -->
    <h1 class="title no-posts-title" id='noPosts'>You have no posts yet!</h1>
</section>
`;

const newPost = (title, imageUrl, id) => html`
        <h2 class="post-title">${title}</h2>
        <img class="post-image" src="${imageUrl}" alt="Material Image">
        <div class="btn-wrapper">
            <a href="/posts/details/${id}" class="details-btn btn">Details</a>
        </div>
`;

export async function myPostsView() {
    const main = document.querySelector('#main-content');
    render(template(), main);
    main.querySelector('#noPosts').style.display = 'none';
    const myPosts = main.querySelector('#myPosts');
    myPosts.style.display = 'none';

    const userData = getUserData();
    const posts = await getMyPosts(userData._id);

    if (posts.length != 0) {
        myPosts.style.display = '';
        myPosts.innerHTML = '';
        posts.forEach(a => {
            const div = document.createElement('div');
            div.className = 'post';

            render(newPost(a.title,a.imageUrl,a._id),div);
            myPosts.appendChild(div);
        });
    } else {
        main.querySelector('#noPosts').style.display = '';
    }
};
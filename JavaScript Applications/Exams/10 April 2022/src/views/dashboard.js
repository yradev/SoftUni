import { getUserData } from '../api/session.js';
import { html, page, render } from '../api/lib.js';
import { getAllPosts, deletePost, addDonation, getAllDonations, isPostDonated } from '../api/posts.js';
import { get } from '../api/request.js';


const newPost = (title, image, details_id) => html`
    <h2 class="post-title">${title}</h2>
    <img class="post-image" src="${image}" alt="Material Image">
    <div class="btn-wrapper">
        <a href="/posts/details/${details_id}" class="details-btn btn">Details</a>
    </div>
`;

const template = () => html`
<section id="dashboard-page">
    <h1 class="title">All Posts</h1>

    <!-- Display a div with information about every post (if any)-->
    <div id='allPosts' class="all-posts">

    </div>

    <!-- Display an h1 if there are no posts -->
    <h1 id='noPosts' class="title no-posts-title">No posts yet!</h1>
</section>
`;

const details = (imageUrl, title, description, address, phone, donates) => html`
<!-- Details Page -->
<section id="details-page">
    <h1 class="title">Post Details</h1>

    <div id="container">
        <div id="details">
            <div class="image-wrapper">
                <img src="${imageUrl}" alt="Material Image" class="post-image">
            </div>
            <div class="info">
                <h2 class="title post-title">${title}</h2>
                <p class="post-description">Description: ${description}</p>
                <p class="post-address">Address: ${address}</p>
                <p class="post-number">Phone number: ${phone}</p>
                <p class="donate-Item">Donate Materials: ${donates}</p>

            </div>
        </div>
    </div>
</section>
`;



export async function dashboardView() {
    render(template(), document.querySelector('#main-content'));

    const allPosts = await getAllPosts();

    if (allPosts.length != 0) {
        document.querySelector('#noPosts').style.display = 'none';
        const allPostsPage = document.querySelector('#allPosts');

        allPostsPage.style.display = '';
        allPostsPage.innerHTML = '';

        allPosts.forEach(a => {
            const div = document.createElement('div');
            div.className = 'post';

            render(newPost(a.title, a.imageUrl, a._id), div);
            allPostsPage.appendChild(div);
        }
        );
    } else {

        document.querySelector('#noPosts').style.display = '';
        document.querySelector('#allPosts').style.display = 'none';
    }
}

export async function detailsView(data) {
    const postId = data.params.id;
    const post = await get('/data/posts/' + postId);
    const main = document.querySelector('#main-content');

    const donations = await getAllDonations(postId);

    render(details(post.imageUrl, post.title, post.description, post.address, post.phone,donations), main);

    const ownerId = post._ownerId;
    const currUserData = getUserData();

    if (currUserData != undefined) {
        const div = document.createElement('div');

        if (currUserData._id == ownerId) {
            div.className = 'btns';

            const editButton = document.createElement('a');
            editButton.className = 'edit-btn btn';
            editButton.textContent = 'Edit';
            editButton.href = '/posts/edit/' + postId;
            div.appendChild(editButton);

            const deleteButton = document.createElement('a');
            deleteButton.className = 'delete-btn btn';
            deleteButton.textContent = 'Delete';
            deleteButton.href = 'javascript:void(0)';
            div.appendChild(deleteButton);

            deleteButton.addEventListener('click', () => {

                if (confirm('Press ok to delete!')) {
                    deletePost(postId);
                }
            });
        } else {
            const donateButton = document.createElement('a');
            donateButton.className = 'donate-btn btn';
            donateButton.textContent = 'Donate';
            donateButton.href = 'javascript:void(0)';

            div.appendChild(donateButton);

            donateButton.addEventListener('click', (event)=>{
                event.preventDefault();
                const result = addDonation(post._id);
                page.redirect('/posts/details/'+postId);
                if(result){
                    donateButton.style.display = 'none';
                }
            });

            const isPostDonatedFromCurrUser = await isPostDonated(postId,getUserData()._id);

            if(isPostDonatedFromCurrUser){
                donateButton.style.display = 'none';
            }
        }
        main.querySelector('.info').appendChild(div);
    }

}
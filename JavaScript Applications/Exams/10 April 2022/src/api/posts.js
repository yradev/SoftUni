import { get, post, put, del } from './request.js';
import { page } from './lib.js';

export async function getAllPosts(){
    return await get('/data/posts?sortBy=_createdOn%20desc');
}

export async function getMyPosts(id){
    return await get(`/data/posts?where=_ownerId%3D%22${id}%22&sortBy=_createdOn%20desc`);
}

export async function createPost(data) {
    if (!Object.values(data).some(a => a == '')) {
        try {
            await post('/data/posts', data);
            page.redirect('/');
        } catch (error) {
            alert(error.message);
        }
    } else {
        alert('We have empty fields!')
    }
}

export async function editPost(data, id) {
    const options = {
        title: data.get('title'),
        description: data.get('description'),
        imageUrl: data.get('imageUrl'),
        address: data.get('address'),
        phone: data.get('phone')
     };

    if (!Object.values(options).some(a => a == '')) {
        try {
            await put('/data/posts/' + id, options);
            page.redirect('/');
        } catch (error) {
            alert(error.message);
        }
    } else {
        alert('We have empty fields!')
    }
}

export async function deletePost(id) {
    try {
        await del('/data/posts/' + id);
    } catch (error) {
        alert(error.message);
    }

}

export async function addDonation(postId) {
    const data = {postId};
    try {
        await post('/data/donations/', data);
        return true;
    } catch (error) {
        alert(error.message);
    }
}

export async function getAllDonations(postId) {
    try {
        return await get(`/data/donations?where=postId%3D%22${postId}%22&distinct=_ownerId&count`);
    } catch (error) {
        alert(error.message);
    }
}

export async function isPostDonated(postId,userId) {
    try {
        const count = await get(`/data/donations?where=postId%3D%22${postId}%22%20and%20_ownerId%3D%22${userId}%22&count`);

        if(count == 0){
            return false;
        }else{
            return true;
        }

    } catch (error) {
        alert(error.message);
    }
}
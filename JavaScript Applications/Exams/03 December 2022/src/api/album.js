import { del, get, post, put } from "./request.js";
import { page } from "./lib.js";
import { detailsPageView } from "../views/detailsPageView.js";
import { getUserData } from "./session.js";

export function getAlbums() {
    try {
        return get('/data/albums?sortBy=_createdOn%20desc')
    } catch (error) {
        alert(error.message);
    }
}

export function getAlbumById(id) {
    try {
        return get(`/data/albums/${id}`)
    } catch (error) {
        alert(error.message);
    }
}
export function addAlbum(options) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        }
        post('/data/albums', options);
        page.redirect('/dashboard')
    } catch (error) {
        alert(error.message);
    }
}

export function editAlbum(options, id){
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        }
        put(`/data/albums/${id}`, options);
        page.redirect('/dashboard')
    } catch (error) {
        alert(error.message);
    }
}

export function deleteAlbum(id){
    try {
        del(`/data/albums/${id}`);
        page.redirect('/dashboard')
    } catch (error) {
        alert(error.message);
    }
}

export function newLike(albumId){
    try {
        post(`/data/likes`,{albumId});
        detailsPageView(albumId);
    } catch (error) {
        alert(error.message);
    }
}

export async function amILiked(albumId){
    try {
        const userId = getUserData()._id;
        return await get(`/data/likes?where=albumId%3D%22${albumId}%22%20and%20_ownerId%3D%22${userId}%22&count`)>0;
    } catch (error) {
        alert(error.message);
    }
}

export function getLikes(albumId){
    try {
        return get(`/data/likes?where=albumId%3D%22${albumId}%22&distinct=_ownerId&count `);
    } catch (error) {
        alert(error.message);
    }
}
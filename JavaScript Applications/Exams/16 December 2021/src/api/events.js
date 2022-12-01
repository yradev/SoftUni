import { del, get, post, put } from "./request.js";
import { page } from "./lib.js";
import { getUserData } from "./session.js";

export function getEvents() {
    try {
        return get('/data/theaters?sortBy=_createdOn%20desc&distinct=title');
    } catch (err) {
        alert(err.message);
    }
};

export function createEvent(options) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        }
        post('/data/theaters', options);
        page.redirect('/');
    } catch (err) {
        alert(err.message);
    }
}

export function editEvent(options, id) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        }
        put(`/data/theaters/${id}`, options);
        page.redirect('/');
    } catch (err) {
        alert(err.message);
    }
}

export function getEventById(id) {
    try {
        return get(`/data/theaters/${id}`);
    } catch (err) {
        alert(err.message);
    }
}

export function deleteEvent(id) {
    try {
        del(`/data/theaters/${id}`);
        page.redirect('/');
    } catch (err) {
        alert(err.message);
    }
}

export function getMyEvents() {
    try {
        const userId = getUserData()._id;
        return get(`/data/theaters?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
    } catch (err) {
        alert(err.message);
    }
}

export function addLike(theaterId) {
    try{
        post('/data/likes', {theaterId});
    } catch (err) {
        alert(err.message);
    }
}

export function getLikes(theaterId){
    try{
        return get(`/data/likes?where=theaterId%3D%22${theaterId}%22&distinct=_ownerId&count`,);
    } catch (err) {
        alert(err.message);
    }
}

export async function isLikedByMe(theaterId){
    try{
        const userId = getUserData()._id;
        return await get(`/data/likes?where=theaterId%3D%22${theaterId}%22%20and%20_ownerId%3D%22${userId}%22&count`,);
    } catch (err) {
        alert(err.message);
    }
}
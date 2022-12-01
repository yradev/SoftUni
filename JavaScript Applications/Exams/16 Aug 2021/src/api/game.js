import { del, get, post, put } from './request.js';
import { page } from './lib.js';
import { getUserData } from './session.js';
import { detailsView } from '../views/detailsView.js';

export function getAllGames() {
    try {
        return get('/data/games?sortBy=_createdOn%20desc');
    } catch (err) {
        alert(err.message);
    }
}

export function getLastGames() {
    try {
        return get('/data/games?sortBy=_createdOn%20desc&distinct=category');
    } catch (err) {
        alert(err.message);
    }
}

export function createGame(options) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        }

        post('/data/games', options)
        page.redirect('/');
    } catch (error) {
        alert(error.message);
    }
}

export function getDetailsById(id) {
    try {

        return get(`/data/games/${id}`)
    } catch (error) {
        alert(error.message);
    }
}

export function editGame(id, options) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        }

        put(`/data/games/${id}`, options)
        page.redirect('/');
    } catch (error) {
        alert(error.message);
    }
}

export function deleteGame(id) {
    try {
        del(`/data/games/${id}`)
        page.redirect('/');
    } catch (error) {
        alert(error.message);
    }
}

export function getAllComments(gameId) {
    try {
       return get(`/data/comments?where=gameId%3D%22${gameId}%22`)
    } catch (error) {
        alert(error.message);
    }
}

export function createNewComment(options) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You need to enter a comment!');
        }
        post('/data/comments',options)
        detailsView(options.gameId);
    } catch (error) {
        alert(error.message);
    }
}
import { del, get, post, put } from "./request.js";
import { page } from "./lib.js";
import { getUserData } from "./session.js";

export function addNewBook(options) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        };

        post('/data/books', options);
        page.redirect('/');
    } catch (err) {
        alert(err.message)
    };
};

export function getAllBooks() {
    try {
        return get('/data/books?sortBy=_createdOn%20desc');
    } catch (err) {
        alert(err.message)
    };
};

export function getBookDetails(id) {
    try {
        return get(`/data/books/${id}`);
    } catch (err) {
        alert(err.message)
    };
};

export function editBook(options, id) {
    try {
        if (Object.entries(options).some(a => a[1] == '')) {
            throw new Error('You have empty fields!');
        };

        put(`/data/books/${id}`, options);
        page.redirect('/');
    } catch (err) {
        alert(err.message)
    };
};

export function deleteBook(id) {
    try {
        del(`/data/books/${id}`);
        page.redirect('/');
    } catch (err) {
        alert(err.message)
    };
};

export function getMyBooks() {
    try {
        const userId = getUserData()._id;
        return get(`/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
    } catch (err) {
        alert(err.message)
    };
}

export function newLike(bookId) {
    try {
        post(`/data/likes`, { bookId });
    } catch (err) {
        alert(err.message)
    };
}

export function getLikes(bookId) {
    try {
        return get(`/data/likes?where=bookId%3D%22${bookId}%22&distinct=_ownerId&count`);
    } catch (err) {
        alert(err.message)
    };
}

export async function amILiked(bookId) {
    try {
        const userId = getUserData()._id;
       return await get(`/data/likes?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`)>0;

    } catch (err) {
        alert(err.message)
    };
}
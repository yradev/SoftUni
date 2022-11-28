import { del, get, post, put } from './request.js';
import { page } from './lib.js';


export function getOffers() {
    return get('/data/offers?sortBy=_createdOn%20desc');
}

export function addOffer(options) {
    try {

        if(Object.entries(options).some(a=>a[1]=='')){
            throw new Error('You have empty fields!')
        }

        post('/data/offers', options);
        page.redirect('/dashboard');

    } catch (err) {
        alert(err.message)
    }
}

export function changeOfferValues(id,options) {
    try {

        if(Object.entries(options).some(a=>a[1]=='')){
            throw new Error('You have empty fields!')
        }

        put(`/data/offers/${id}`, options);
        page.redirect('/dashboard');

    } catch (err) {
        alert(err.message)
    }
}

export function deleteOffer(id) {
    try {
        del(`/data/offers/${id}`);
        page.redirect('/dashboard');

    } catch (err) {
        alert(err.message)
    }
}

export async function isUserApplied(offerId,userId){
   return await get(`/data/applications?where=offerId%3D%22${offerId}%22%20and%20_ownerId%3D%22${userId}%22&count`)!=0;
}

export function applyOffer(offerId){
    try {
        post(`/data/applications`,{offerId});
    } catch (err) {
        alert(err.message)
    }
}

export function getApplies(offerId){
    return get(`/data/applications?where=offerId%3D%22${offerId}%22&distinct=_ownerId&count`);
}
import { del, get, post, put } from "./request.js";
import { page } from "./lib.js";


export async function createPair(options) {
    try{
        if(Object.entries(options).some(a=>a[1]=='')){
            throw new Error('You have empty fields!');
        }

        await post('/data/shoes',options);
        page.redirect('/dashboard')
    }catch(err){
        alert(err.message);
    }
}

export async function editPair(id, options) {
    try{
        if(Object.entries(options).some(a=>a[1]=='')){
            throw new Error('You have empty fields!');
        }

        await put(`/data/shoes/${id}`,options);
        page.redirect('/dashboard')
    }catch(err){
        alert(err.message);
    }
}

export async function deleteShoe(id) {
    try{
        await del(`/data/shoes/${id}`);
        page.redirect('/dashboard')
    }catch(err){
        alert(err.message);
    }
}

export function getAllShoes(){
    try{
        return get('/data/shoes?sortBy=_createdOn%20desc');
    }catch(err){
        alert(err.message);
    }
}

export function getShoe(query){
    try{
        return get(`/data/shoes?where=brand%20LIKE%20%22${query}%22`);
    }catch(err){
        console.log(err.message);
    }
}
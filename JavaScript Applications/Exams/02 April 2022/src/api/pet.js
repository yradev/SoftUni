import { del, get, post, put } from "./request.js";
import { page } from "./lib.js";


export async function getPets(){
    return await get('/data/pets?sortBy=_createdOn%20desc&distinct=name');
}

export function createPostcard(formData){
    const options = {
        name: formData.get('name'),
        breed: formData.get('breed'),
        age: formData.get('age'),
        weight: formData.get('weight'),
        image: formData.get('image')
    }

    if(!Object.values(options).some(a=>a == '')){

        post('/data/pets',options);
        page.redirect('/dashboard');

    }else{
        alert('Fields cannot be empty!');
    }
}

export async function getPetById(petId){
    return await get(`/data/pets/${petId}`);
}

export function editPet(formData,petId){
    const options = {
        name: formData.get('name'),
        breed: formData.get('breed'),
        age: formData.get('age'),
        weight: formData.get('weight'),
        image: formData.get('image')
    }

    if(Object.values(options).some(a=>a=='')){
        alert('We cannot have empty fields!')
    }else{
        put('/data/pets/'+ petId,options);
        page.redirect('/dashboard')
    }
}

export function deletePet(petId){
    del('/data/pets/'+petId);
    page.redirect('/dashboard')
}

export async function getDonations(petId){
   const donations = await get(`/data/donation?where=petId%3D%22${petId}%22&distinct=_ownerId&count`);
   return donations * 100;
}

export async function isUserDonated(petId, userId){
    return await get(`/data/donation?where=petId%3D%22${petId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
}

export function addDonation(petId){
    post('/data/donation',{petId});
}
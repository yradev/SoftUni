import { get } from "./request.js";

export function getUserData(){
    return JSON.parse(sessionStorage.getItem('userData'));
};

export function setUserData(data){
    sessionStorage.setItem('userData',JSON.stringify(data));
};

export async function clearUserData(){
    sessionStorage.removeItem('userData');
}
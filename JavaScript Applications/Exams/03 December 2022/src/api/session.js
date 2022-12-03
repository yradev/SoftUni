export function getUserData(){
    return JSON.parse(sessionStorage.getItem('userData'));
};

export function setUserData(data){
    sessionStorage.setItem('userData',JSON.stringify(data));
};

export async function clearUserData(){
    sessionStorage.removeItem('userData');
}

export function amICreator(ownerId) {
    return getUserData()._id==ownerId?true:false;
}
const array = [14, 7, 17, 6, 8];
let sorting = 'asc';


function solve (sortedArray, sorting) {

   if(sorting == 'asc'){
    sortedArray.sort((a,b)=>a - b);
   }else{
    sortedArray.sort((a,b)=>b-a);
   }
   
   return sortedArray;
}

let sortedArray = solve(array,sorting);



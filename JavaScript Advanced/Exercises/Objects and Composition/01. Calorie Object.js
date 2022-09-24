function solve(array){
const object = {};
for(let index=0; index<array.length; index++){
    if(index%2!=0){
        object[array[index-1]]=Number(array[index]);
    }
}

console.log(object);
};

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
solve(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);
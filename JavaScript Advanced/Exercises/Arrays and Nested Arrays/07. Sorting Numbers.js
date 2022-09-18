function solve(array){
    const finalArray = [];
    array.sort((a,b)=>a-b);

    while(array.length>0){
        finalArray.push(array.shift());
        finalArray.push(array.pop())
    }

    return finalArray;
};

solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);
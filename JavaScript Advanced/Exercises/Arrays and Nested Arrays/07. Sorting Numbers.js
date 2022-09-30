// function solve(array){
//     const finalArray = [];
//     array.sort((a,b)=>a-b);

//     while(array.length>0){
//         finalArray.push(array.shift());
//         finalArray.push(array.pop())
//     }

//     return finalArray;
// };

function echo(array) {
    let result = [];
    array.sort(function(a, b){return a - b});
    let biggest = 0;
    let smallest = 0;
    let counter = 0;
     
     
    for(let el of array){
    result.push(el);
    // counter=0;
    while(counter === 0){
        smallest = array.pop();
        result.push(smallest);
        // counter=1;
        break;
    }
     
    }
     
    return result;
    }

console.log(echo([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));
function solve(matrix){

let sum;;

for(let index = 0; index<matrix.length; index++){

    let tempSum = matrix[index].reduce((acomulator,value)=>acomulator+value,0);

    if(sum == undefined){
        sum = tempSum;
    }

    
    if(sum!=tempSum){
        return false;
    }

    let colSum = matrix
    .map(row=>row[index])
    .reduce((acomulator,value)=>acomulator+value,0);

    if(sum!=colSum){
        return false;
    }

}

return true;
}

console.log(
    solve([
    [11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]
]));

console.log(solve(
    [[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
   ));
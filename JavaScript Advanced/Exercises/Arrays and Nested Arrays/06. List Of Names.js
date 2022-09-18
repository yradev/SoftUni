function solve(array){

    let positionCounter =1;

    array
    .sort((a,b)=>a.localeCompare(b))
    .forEach(x=>console.log(`${positionCounter++}.${x}`));

};

solve(["John", "Bob", "Christina", "Ema"]);
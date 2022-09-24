function solve(array) {
    
    let towns = [];

    for (let index = 1; index < array.length; index++) {

        let split = array[index].split(/\s+\|\s+|\|\s+|\s+\|/);

        towns.push({
            Town: split[1],
            Latitude: Number(Number(split[2]).toFixed(2)),
            Longitude: Number(Number(split[3]).toFixed(2))
        })
    }

    return JSON.stringify(towns);
}

console.log(solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));
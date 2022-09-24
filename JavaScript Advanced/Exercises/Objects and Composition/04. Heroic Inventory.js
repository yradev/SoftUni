function solve(array) {

    const heroInventary = [];

    for (let index = 0; index < array.length; index++) {
        let splitHero = array[index].split(' / ');
        let name = splitHero[0];
        let level = Number(splitHero[1]);
        let items = splitHero.length > 2 ? splitHero[2].split(', ') : [];


        heroInventary[index] = {
            name, level, items
        }
    }


    return JSON.stringify(heroInventary);
}

solve(
    ['Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara']
);
function solve(array) {

    const products = [];

    for (let index = 0; index < array.length; index++) {

        const split = array[index].split(' | ');
        let townName = split[0];
        let productName = split[1];
        let productPrice = Number(split[2]);

        const object = {
            townName, productName, productPrice
        }

        if (products.some(a => a.productName == productName)) {
            let indexOfProduct = products.indexOf(products.find(a => a.productName == productName));

            if (productPrice < products[indexOfProduct].productPrice) {
                products[indexOfProduct].townName = townName;
                products[indexOfProduct].productPrice = productPrice;
            }
        } else {
            products.push(object);
        }
    }

    products.forEach(a => console.log(`${a.productName} -> ${a.productPrice} (${a.townName})`));

}

solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10',
]
);

solve([
'Sofia City | Audi | 100000',
'Sofia City | BMW | 100000',
'Sofia City | Mitsubishi | 10000',
'Sofia City | Mercedes | 10000',
'Sofia City | NoOffenseToCarLovers | 0',
'Mexico City | Audi | 1000',
'Mexico City | BMW | 99999'
])
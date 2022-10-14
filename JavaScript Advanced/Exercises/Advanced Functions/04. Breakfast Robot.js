function solve() {

    const orders = [
        { name: 'apple', protein: 0, carbohydrate: 1, fat: 0, flavour: 2 },
        { name: 'lemonade', protein: 0, carbohydrate: 10, fat: 0, flavour: 20 },
        { name: 'burger', protein: 0, carbohydrate: 5, fat: 7, flavour: 3 },
        { name: 'eggs', protein: 5, carbohydrate: 0, fat: 1, flavour: 1 },
        { name: 'turkey', protein: 10, carbohydrate: 10, fat: 10, flavour: 10 },
    ]

    const stocks = [
        { name: 'protein', bag: 0 },
        { name: 'carbohydrate', bag: 0 },
        { name: 'fat', bag: 0 },
        { name: 'flavour', bag: 0 }
    ]

    return (task) => {
        let split = task.split(' ');

        let instruction = split[0];

        let quantity;

        switch (instruction) {
            case 'restock':
                let microelement = split[1];
                quantity = Number(split[2]);

                stocks.find(arg => arg.name == microelement).bag += quantity;
                break;

            case 'prepare':
                let recipe = split[1];
                quantity = Number(split[2]);



                const order = Object.entries(orders.find(order => order.name == recipe));

                for (let [key, value] of order) {
                    let rec = stocks.find(value => value.name == key);
                    if (rec != undefined) {

                        if (rec.bag < value * quantity) {
                            return `Error: not enough ${key} in stock`;
                        }
                    }
                }

                for (let [key, value] of order) {
                    if (key != 'name') {
                        stocks.find(arg => arg.name == key).bag -= value * quantity;
                    }
                }
                break;

            case 'report':
                let returnMessage = [];

                for (let stock of stocks) {
                    returnMessage.push(`${stock.name}=${stock.bag}`);
                }
                return returnMessage.join(' ');
        }

        return 'Success';
    }
}

let manager = solve();
console.log(manager("restock flavour 50"));
console.log(manager("prepare lemonade 4"));
console.log(manager("restock carbohydrate 10"));
console.log(manager('restock flavour 10'));
console.log(manager('prepare apple 1'));
console.log(manager('restock fat 10'));
console.log(manager('prepare burger 1'));
console.log(manager('report'));


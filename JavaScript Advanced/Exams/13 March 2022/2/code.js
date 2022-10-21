class CarDealership {
    constructor(name) {
        this.name = name;
        this.availableCars = [];
        this.soldCars = [];
        this.totalIncome = 0;
    }

    addCar(model, horsepower, price, mileage) {
        if (
        model == '' 
        || !Number.isInteger(horsepower) 
        || horsepower < 0 
        || price < 0 
        || mileage < 0) {
            throw new Error('Invalid input!')
        }

        this.availableCars.push({ model, horsepower, price, mileage });

        return `New car added: ${model} - ${horsepower} HP - ${Number(mileage).toFixed(2)} km - ${Number(price).toFixed(2)}$`;
    }

    sellCar(model, desiredMileage) {
        const car = this.availableCars.filter(a => a.model == model)[0];

        if (car == undefined) {
            throw new Error(`${model} was not found!`);
        }

        let soldPrice;

        if (car.mileage <= desiredMileage) {
            soldPrice = car.price;;
        } else {
            soldPrice = car.price;
            if (Math.abs(car.mileage - desiredMileage) <= 40000) {
                soldPrice -= soldPrice * 0.05;
            } else {
                soldPrice -= soldPrice * 0.1;
            };
        }

        this.totalIncome += soldPrice;

        this.soldCars.push({ model, horsepower: car.horsepower, soldPrice });
        this.availableCars.splice(car, 1);

        return `${model} was sold for ${soldPrice.toFixed(2)}$`;
    }

    currentCar() {
        if (this.availableCars.length == 0) {
            return "There are no available cars";
        }

        return `-Available cars:\n${this.availableCars.map(a => `---${a.model} - ${a.horsepower} HP - ${a.mileage.toFixed(2)} km - ${a.price.toFixed(2)}$`).join('\n')}`;
    }

    salesReport(criteria) {

        switch (criteria) {
            case 'horsepower':
                this.soldCars.sort((a, b) => b.horsepower - a.horsepower);
                break;
            case 'model':
                this.soldCars.sort((a, b) => a.model.localeCompare(b.model));
                break;
            default:
                throw new Error('Invalid criteria!');
        }

        return `-${this.name} has a total income of ${this.totalIncome.toFixed(2)}$\n-${this.soldCars.length} cars sold:\n${this.soldCars.map(a=>`---${a.model} - ${a.horsepower} HP - ${a.soldPrice.toFixed(2)}$`).join('\n')}`
    }
}
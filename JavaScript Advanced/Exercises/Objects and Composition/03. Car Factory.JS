function solve(object) {

    const generator = {
        power: object.power, carriage: object.carriage, color: object.color, wheelsize: object.wheelsize,
        generateEngine() {
            let volume;
            let power;
            if (this.power <= 90) {
                power = 90;
                volume = 1800;
            } else if (this.power > 90 && this.power <= 120) {
                power = 120;
                volume = 2400;
            } else {
                power = 200;
                volume = 3500;
            }
            return { power: power, volume: volume };
        },
        generateCarriage() {
            return {
                type: this.carriage,
                color: this.color
            }
        },
        generateWheels() {
            let wheelsize = this.wheelsize;
            if (wheelsize % 2 == 0) {
                wheelsize -= 1;
            }
            const wheels = [];
            for (let index = 0; index < 4; index++) {
                wheels[index] = wheelsize;
            }

            return wheels;
        }

    }

    return {
        model: object.model,
        engine: generator.generateEngine(),
        carriage: generator.generateCarriage(),
        wheels: generator.generateWheels()
    }

}

console.log(solve({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
})
)

console.log(solve({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}));
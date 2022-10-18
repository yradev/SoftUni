class Garden {
    constructor(spaceAvailable){
        this.spaceAvailable = Number(spaceAvailable);
        this.plants = [];
        this.storage = [];
    };

    addPlant(plantName, spaceRequired){
        if(this.spaceAvailable<Number(spaceRequired)){
            throw new Error('Not enough space in the garden.');
        }

        this.plants.push({plantName: plantName, spaceRequired: spaceRequired, ride: false, quantity: 0});

        this.spaceAvailable-=Number(spaceRequired);
        return `The ${plantName} has been successfully planted in the garden.`;
    };

    ripenPlant(plantName, quantity){
        const plant = this.plants.filter(a=>a.plantName == plantName);

        if(plant.length == 0){
            throw new Error(`There is no ${plantName} in the garden.`);
        }

        if(plant[0].ride){
            throw new Error(`The ${plantName} is already ripe.`);
        }

        if(quantity<=0){
            throw new Error('The quantity cannot be zero or negative.');
        }

        if(quantity==1){
            this.plants[this.plants.indexOf(this.plants.filter(a=>a.plantName == plantName)[0])].quantity = 1;
            this.plants[this.plants.indexOf(this.plants.filter(a=>a.plantName == plantName)[0])].ride = true;
            return `${quantity} ${plantName} has successfully ripened.`;
        }else{
            this.plants[this.plants.indexOf(this.plants.filter(a=>a.plantName == plantName)[0])].quantity = quantity;
            this.plants[this.plants.indexOf(this.plants.filter(a=>a.plantName == plantName)[0])].ride = true;
            return `${quantity} ${plantName}s have successfully ripened.`;
        }
    }

    harvestPlant(plantName){
        const plant = this.plants.filter(a=>a.plantName == plantName);

        if(plant.length == 0){
            throw new Error(`There is no ${plantName} in the garden.`);
        }

        if(!plant[0].ride){
            throw new Error(`The ${plantName} cannot be harvested before it is ripe.`);
        }

        this.plants.splice(this.plants.indexOf(this.plants.filter(a=>a.plantName == plantName)[0]),1);

        this.spaceAvailable += Number(plant[0].spaceRequired);

        this.storage.push({plantName:plantName, quantity: plant[0].quantity});
        return `The ${plantName} has been successfully harvested.`;
    }

    generateReport(){
        const plantNames = this.plants.map(a=>a.plantName).join(', ')

        let storageInputs;

        if(this.storage.length == 0){
            storageInputs = 'The storage is empty.';
        }else{
            const storages = [];

            for(let storage of this.storage){
                storages.push(`${storage.plantName} (${storage.quantity})`)
            }

            storageInputs = `${storages.join(', ')}`;
        }

        return `The garden has ${this.spaceAvailable} free space left.\nPlants in the garden: ${plantNames}\nPlants in storage: ${storageInputs}`;
    }
}

const myGarden = new Garden(250)
console.log(myGarden.addPlant('apple', 20));
console.log(myGarden.addPlant('orange', 100));
console.log(myGarden.addPlant('cucumber', 30));
console.log(myGarden.ripenPlant('apple', 10));
console.log(myGarden.ripenPlant('orange', 1));
console.log(myGarden.ripenPlant('orange', 4));


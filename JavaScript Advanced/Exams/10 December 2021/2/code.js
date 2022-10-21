class VegetableStore {
    constructor(owner, location) {
        this.owner = owner;
        this.location = location;
        this.avaliableProducts = [];
    }

    loadingVegetables(vegetables) {
        const types = new Set();

        for (let vegetable of vegetables) {
            const vegetableSplit = vegetable.split(' ');
            let type = vegetableSplit[0];
            let quantity = Number(vegetableSplit[1]);
            let price = Number(vegetableSplit[2]);

            const avaliableVegetable = this.avaliableProducts.filter(a => a.type == type)[0];

            if (avaliableVegetable != undefined) {
                let index = this.avaliableProducts.indexOf(avaliableVegetable);
                avaliableVegetable.quantity += quantity;
                if (price > avaliableVegetable.price) {
                    avaliableVegetable.price = price;
                }

                this.avaliableProducts.fill(avaliableVegetable, index,index)
            } else {
                this.avaliableProducts.push({ type, quantity, price });
            }
            types.add(type);
        }

        return `Successfully added ${[...types].join(', ')}`;
    }

    buyingVegetables(selectedProducts) {
        let totalPrice = 0;
        for (let product of selectedProducts) {
            const productSplit = product.split(' ');
            let type = productSplit[0];
            let quantity = productSplit[1];

            const avProduct = this.avaliableProducts.filter(a => a.type == type)[0];
            const index = this.avaliableProducts.indexOf(avProduct);
            if (avProduct == undefined) {
                throw new Error(`${type} is not available in the store, your current bill is $${totalPrice.toFixed(2)}.`);
            }

            if (quantity > avProduct.quantity) {
                throw new Error(`The quantity ${quantity} for the vegetable ${type} is not available in the store, your current bill is $${totalPrice.toFixed(2)}.`);
            }

            let cost = quantity * avProduct.price;
            avProduct.quantity -= quantity;
            this.avaliableProducts.fill(avProduct, index, index);
            totalPrice += cost;
        }

        return `Great choice! You must pay the following amount $${totalPrice.toFixed(2)}.`;
    }

    rottingVegetable(type, quantity) {
        const avProduct = this.avaliableProducts.filter(a => a.type == type)[0];

        if (avProduct == undefined) {
            throw new Error(`${type} is not available in the store.`);
        }

        let index = this.avaliableProducts.indexOf(avProduct);

        if (quantity > avProduct.quantity) {
            avProduct.quantity = 0;
            this.avaliableProducts.fill(avProduct, index, index);
            return `The entire quantity of the ${type} has been removed.`;

        } else {
            avProduct.quantity -= quantity;
            this.avaliableProducts.fill(avProduct,index,index); 
            return `Some quantity of the ${type} has been removed.`;
        }

    }

    revision() {
        return `Available vegetables:\n${this.avaliableProducts
            .sort((a, b) => a.price - b.price)
            .map(a => `${a.type}-${a.quantity}-$${a.price}`)
            .join('\n')}\nThe owner of the store is ${this.owner}, and the location is ${this.location}.`;
    }
}

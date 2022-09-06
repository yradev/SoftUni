function fruitPrice(type,weightInGram,pricePerKG){
    let kg = weightInGram*0.001;
    let totalprice = kg*pricePerKG;
    console.log(`I need $${totalprice.toFixed(2)} to buy ${kg.toFixed(2)} kilograms ${type}.`)
}

fruitPrice('orange', 2500, 1.80);
fruitPrice('apple', 1563, 2.35);
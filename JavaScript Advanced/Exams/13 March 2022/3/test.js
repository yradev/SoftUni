const { rentCar } = require('./code');
const { assert } = require('../../node_modules/chai');

describe('Test rentCar object', () => {

    describe('Test searchCar method', () => {
        it('Test invalid input', () => {
            assert.throw(() => rentCar.searchCar('Shop Is Not Array', 123),'Invalid input!');
            assert.throw(() => rentCar.searchCar([1,2], 123),'Invalid input!');
            assert.throw(() => rentCar.searchCar('Shop Is Not Array', 'any string'),'Invalid input!');
        });

        it('Test not found model', ()=>{
            assert.throw(() => rentCar.searchCar([], 'Any string'),'There are no such models in the catalog!');
        });

        it('Test found model', ()=>{
            assert.equal(rentCar.searchCar(['audi'], 'audi'),'There is 1 car of model audi in the catalog!');
        });
    });

    describe('Test calculatePriceOfCar method',()=>{
        it('Test invalid input', ()=>{
            assert.throw(() => rentCar.calculatePriceOfCar(123, 123),'Invalid input!');
            assert.throw(() => rentCar.calculatePriceOfCar('Valid input', 'Invalid input'),'Invalid input!');
            assert.throw(() => rentCar.calculatePriceOfCar(123, 'Invalid input'),'Invalid input!');
        });

        it('Test no such model',()=>{
            assert.throw(() => rentCar.calculatePriceOfCar('Not found model', 123),'No such model in the catalog!');
        });

        it('Test choose model',()=>{
            assert.equal(rentCar.calculatePriceOfCar('Audi', 123),'You choose Audi and it will cost $4428!');
        });
    });

    describe('Test checkBudget',()=>{
        it('Test invalid input',()=>{
            assert.throw(() => rentCar.checkBudget('Invalid input',123,123),'Invalid input!');
            assert.throw(() => rentCar.checkBudget(123,'Invalid input',123),'Invalid input!');
            assert.throw(() => rentCar.checkBudget(123,123,'Invalid input'),'Invalid input!');
        });

        it('Test rent a car', () => {
            assert.equal(rentCar.checkBudget(1,2,3),'You rent a car!');
            assert.equal(rentCar.checkBudget(1,2,2),'You rent a car!');

        });

        it('Test You need a bigger budget!', () => {
            assert.equal(rentCar.checkBudget(3,2,3),'You need a bigger budget!');
        });
    });
});
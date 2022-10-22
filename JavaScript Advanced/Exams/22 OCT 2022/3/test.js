const { assert } = require('../../node_modules/chai');
const { chooseYourCar } = require('./code');

describe('Test chooseYourCar object', () =>{
    describe('Test choosingType method', ()=>{
        it('testing Invalid Year!',()=>{
            assert.throw(()=>chooseYourCar.choosingType('type','color',1899),'Invalid Year!');
            assert.throw(()=>chooseYourCar.choosingType('type','color',2023),'Invalid Year!');
        });
        it('testing type is not sedan',()=>{
            assert.throw(()=>{chooseYourCar.choosingType('notSedan','color',2020),'This type of car is not what you are looking for.'});
        });
        describe('testing is type sedan', ()=>{
            it('testing year more or equal 2010', () =>{
                assert.equal(chooseYourCar.choosingType('Sedan','black',2020),'This black Sedan meets the requirements, that you have.');
                assert.equal(chooseYourCar.choosingType('Sedan','black',2010),'This black Sedan meets the requirements, that you have.');
            });
            it('testing year less than 2010', () =>{
                assert.equal(chooseYourCar.choosingType('Sedan','black',2009),'This Sedan is too old for you, especially with that black color.');
            });
        });
    });
    describe('testing brandName method', () =>{
        it('testing Invalid Information', () =>{
            assert.throw(()=>{chooseYourCar.brandName('brands is not array',0),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.brandName([],1.2),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.brandName([],0),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.brandName([],1),'Invalid Information!'});
        });

        it('testing result', ()=>{
            assert.equal(chooseYourCar.brandName(['brand1','brand2','brand3'],2),'brand1, brand2')
        });
    });
    describe('testing carFuelConsumption method',()=>{
        it('test Invalid Information', ()=>{
            assert.throw(()=>{chooseYourCar.carFuelConsumption('',1),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.carFuelConsumption(1,''),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.carFuelConsumption(1,0),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.carFuelConsumption(0,1),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.carFuelConsumption(-1,2),'Invalid Information!'});
            assert.throw(()=>{chooseYourCar.carFuelConsumption(2,-1),'Invalid Information!'});
        });
        it('testing litersPerHundredKm less and equal to 7',()=>{
            assert.equal(chooseYourCar.carFuelConsumption(2,0.14),'The car is efficient enough, it burns 7.00 liters/100 km.')
            assert.equal(chooseYourCar.carFuelConsumption(2,0.13),'The car is efficient enough, it burns 6.50 liters/100 km.')
        });

        it('testing litersPerHundredKm more than 7',()=>{
            assert.equal(chooseYourCar.carFuelConsumption(2,0.15),'The car burns too much fuel - 7.50 liters!')
        })
    });
});
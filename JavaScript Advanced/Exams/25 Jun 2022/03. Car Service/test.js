const { carService } = require('./code');
const { assert, expect } = require('../node_modules/chai');

describe('Test carService', () => {

    describe('Test isItExpensive method', () => {

        it('issue is equal to Engine', () => {
            assert.equal(carService.isItExpensive('Engine'), `The issue with the car is more severe and it will cost more money`);
        })

        it('issue is equal to Transmission', () => {
            assert.equal(carService.isItExpensive('Transmission'), `The issue with the car is more severe and it will cost more money`);
        })

        it('issue is not equal to Engine or Transmission', () => {
            assert.equal(carService.isItExpensive('failure'), `The overall price will be a bit cheaper`);
        })
    })

    describe('test discount method', () => {
        it('throw exception', () => {
            assert.throw(() => carService.discount('failure', 123), "Invalid input");
            assert.throw(() => carService.discount('failure', 'failure'), "Invalid input");
            assert.throw(() => carService.discount(123, 'failure'), "Invalid input");
        });

        it('Cannot apply a discount', () => {
            assert.equal(carService.discount(0, 123), "You cannot apply a discount");
            assert.equal(carService.discount(1, 123), "You cannot apply a discount");
            assert.equal(carService.discount(2, 123), "You cannot apply a discount");
        });

        it('Discount applied', () => {
            assert.equal(carService.discount(3, 10), 'Discount applied! You saved 1.5$');
            assert.equal(carService.discount(7, 10), 'Discount applied! You saved 1.5$');
            assert.equal(carService.discount(8, 10), 'Discount applied! You saved 3$');
        });
    })

    describe('test partsToBuy mothod', () => {

        it('Invalid input', () => {
            assert.throw(() => carService.partsToBuy('notAray', [1, 2]), 'Invalid input');
            assert.throw(() => carService.partsToBuy([1,2], 'notArray'), 'Invalid input');
            assert.throw(() => carService.partsToBuy('notAray', 'notArray'), 'Invalid input');
        })

        it('totalSum', () => {
            assert.equal(carService.partsToBuy([{part: 'part1', price: Number(123)}],['part1']),123)
        })

    })


})



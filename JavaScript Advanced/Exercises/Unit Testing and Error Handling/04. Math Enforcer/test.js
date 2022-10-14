const { assert } = require('../node_modules/chai');
const { mathEnforcer } = require('./code');

describe('Math Enforcer', () => {

    describe('Addfive function', () => {

        it('Addfive float', () => {
            assert.equal(mathEnforcer.addFive(10.1), 10.1 + 5);
        });

        it('Addfive is not a num', () => {
            assert.typeOf(mathEnforcer.addFive('false'), 'undefined');
        });

        it('Addfive negative numver', () => {
            assert.equal(mathEnforcer.addFive(-2), 3);
        })

        it('Addfive positive numve', () => {
            assert.equal(mathEnforcer.addFive(2), 7);
        });

    });

    describe('Subtract function', () => {

        it('Subtract float', () => {
            assert.equal(mathEnforcer.subtractTen(10.001), 10.001 - 10);
        });

        it('Subtract is not a number', () => {
            assert.typeOf(mathEnforcer.subtractTen('10'), 'undefined');
        });

        it('Subtract is a negative number', () => {
            assert.equal(mathEnforcer.subtractTen(-8), -18);
        });

        it('Subtract is a positive number', () => {
            assert.equal(mathEnforcer.subtractTen(11), 1);
        });

    });


    describe('Sum function', () => {
        it('First agrument of sum is not a number', () => {
            assert.typeOf(mathEnforcer.sum('2', 2), 'undefined');
        });

        it('First argument is float', () => {
            assert.equal(mathEnforcer.sum(2.202, 1), 2.202 + 1);
        });

        it('First argument of sum is negative number', () => {
            assert.equal(mathEnforcer.sum(-2, 2), 0);
        });

        it('Second argument of sum is not a number', () => {
            assert.typeOf(mathEnforcer.sum(2, '2'), 'undefined');
        });

        it('Second argument of sum is negative number', () => {
            assert.equal(mathEnforcer.sum(2, -2), 0);
        });

        it('Second argument is float', () => {
            assert.equal(mathEnforcer.sum(1, 2.20), 1 + 2.20);
        });

        it('Two argoments are negative', () => {
            assert.equal(mathEnforcer.sum(-2, -2), -4);

        });

        it('Two argoments are Positive', () => {
            assert.equal(mathEnforcer.sum(2, 2), 4);
        });

        it('Two argoments are float', () => {
            assert.equal(mathEnforcer.sum(1.22, 2.22), 1.22 + 2.22);

        });

    });

});
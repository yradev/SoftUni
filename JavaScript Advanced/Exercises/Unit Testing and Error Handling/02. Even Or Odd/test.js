const { expect, assert } = require('../node_modules/chai');
const { isOddOrEven } = require('./function.js');

describe('Is Odd or Even', () => {

    it('input is not String', () => expect(isOddOrEven(23)).to.be.undefined);

    it('input is String', () => expect(isOddOrEven('wau')).to.be.string);


    it('input is odd', () => assert.equal(isOddOrEven('asd'), 'odd'));
    it('input is odd', () => assert.equal(isOddOrEven('as'), 'even'));
})
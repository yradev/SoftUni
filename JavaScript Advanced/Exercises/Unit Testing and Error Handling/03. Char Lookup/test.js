const { lookupChar } = require('./code');
const { assert } = require('../node_modules/chai');


describe ('lookup Character', () => {

    it('Text is not string', () =>{
        assert.typeOf(lookupChar(23,2),'undefined');
    });

    it('Index is not a Number', () =>{
        assert.typeOf(lookupChar('true','false'),'undefined');
    });

    it('Index is not a ineger', () =>{
        assert.typeOf(lookupChar('123',1.233),'undefined');
    });

    it('String length is less than integer', () =>{
        assert.equal(lookupChar('123',4),'Incorrect index');
    });

    it('String length is equal to integer', () =>{
        assert.equal(lookupChar('123',3),'Incorrect index');
    });

    it('Index is negative number', () =>{
        assert.equal(lookupChar('123',-1),'Incorrect index');
    })

    it('Everything is ok!', () =>{
        assert.equal(lookupChar('123',1),'2');
    })
})
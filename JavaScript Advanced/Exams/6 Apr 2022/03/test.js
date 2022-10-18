const { bookSelection } = require('./code');
const { assert } = require('../node_modules/chai');

describe('Test bookSelection object', () => {

    describe('Test isGenreSuitable method', () => {

        it('Test books are not suitable', () => {
            assert.equal(bookSelection.isGenreSuitable('Thriller', 12), 'Books with Thriller genre are not suitable for kids at 12 age');
            assert.equal(bookSelection.isGenreSuitable('Thriller', 11), 'Books with Thriller genre are not suitable for kids at 11 age');
            assert.equal(bookSelection.isGenreSuitable('Horror', 12), 'Books with Horror genre are not suitable for kids at 12 age');
            assert.equal(bookSelection.isGenreSuitable('Horror', 11), 'Books with Horror genre are not suitable for kids at 11 age');
        });

        it('Test books are suitable', () => {
            assert.equal(bookSelection.isGenreSuitable('Thriller', 13), 'Those books are suitable');
            assert.equal(bookSelection.isGenreSuitable('Horror', 13), 'Those books are suitable');
            assert.equal(bookSelection.isGenreSuitable('failure', 12), 'Those books are suitable');
            assert.equal(bookSelection.isGenreSuitable('failure', 11), 'Those books are suitable');
        });

    })

    describe('Test isItAffordable method', () => {
        it('Test invalid input', () => {
            assert.throw(() => bookSelection.isItAffordable('not A Number', 1), 'Invalid input');
            assert.throw(() => bookSelection.isItAffordable(1, 'not A Number'), 'Invalid input');
            assert.throw(() => bookSelection.isItAffordable('not A Number', 'not A Number'), 'Invalid input');
        });

        it('Test Dont have enought money', () => {
            assert.equal(bookSelection.isItAffordable(3, 2), "You don't have enough money");
        });

        it('Test Have enought money', () => {
            assert.equal(bookSelection.isItAffordable(2, 3), "Book bought. You have 1$ left");
        });
    });

    describe('Test suitableTitles method', () => {
        it('Test Invalid input', () => {
            assert.throw(() => bookSelection.suitableTitles('I am not array','I am String'),'Invalid input');
            assert.throw(() => bookSelection.suitableTitles([],123),'Invalid input');
            assert.throw(() => bookSelection.suitableTitles('I am not array',13),'Invalid input');
        });

        it('Test result', () =>{
            const result = ['title'];
            assert.lengthOf(bookSelection.suitableTitles([{genre: 'genre',title: 'title'}],'genre'),1);
        });
    });
})
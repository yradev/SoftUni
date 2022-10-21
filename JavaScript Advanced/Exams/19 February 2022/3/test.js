const { flowerShop } = require('./code');
const { assert } = require('../../node_modules/chai');

describe('Test flowerShop object', () =>{
    describe('Test calcPriceOfFlowers method', () =>{
        it('Test invalid input', ()=>{
            assert.throw(()=>{flowerShop.calcPriceOfFlowers(1,'',''),'Invalid input!'});
            assert.throw(()=>{flowerShop.calcPriceOfFlowers('',1,''),'Invalid input!'});
            assert.throw(()=>{flowerShop.calcPriceOfFlowers('','',1),'Invalid input!'});
        });

        it('Test return calculated price',()=>{
            assert.equal(flowerShop.calcPriceOfFlowers('flower',1,2),'You need $2.00 to buy flower!');
        });
    });
    describe('Test checkFlowersAvailable method',()=>{
        it('Test the flower are avaliable!', () =>{
            assert.equal(flowerShop.checkFlowersAvailable('flower',['flower']),'The flower are available!')
        });

        it('Test the flower are sold!', () => {
            assert.equal(flowerShop.checkFlowersAvailable('flower',[]),'The flower are sold! You need to purchase more!')
        });
    });
    describe('Test sellFlowers',()=>{
        it('Test invalid input',()=>{
            assert.throw(()=>{flowerShop.sellFlowers('',1),'Invalid input!'});
            assert.throw(()=>{flowerShop.sellFlowers([],''),'Invalid input!'});
            assert.throw(()=>{flowerShop.sellFlowers([],-1),'Invalid input!'});
            assert.throw(()=>{flowerShop.sellFlowers([],2),'Invalid input!'});
            assert.throw(()=>{flowerShop.sellFlowers([],1),'Invalid input!'});
        });

        it('Test return sold floowers', () => {
            assert.equal(flowerShop.sellFlowers(['flower1','flower2','flower3'],2),'flower1 / flower2');
        });
    });
});
package shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ShopTest {
    private Shop shop;
    private Goods goods1;
    private Goods goods2;

    @Before
    public void set(){
        shop = new Shop();
        goods1 = new Goods("Pinguin","123");
        goods2 = new Goods("Fish","222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConteinsKeyAdd() throws OperationNotSupportedException {
        shop.addGoods("god",goods1);
    }

    @Test(expected = OperationNotSupportedException.class)
        public void testContainsValueAdd() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", goods1);
        this.shop.addGoods("Shelves5", goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExistNotNullShelf() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves7", goods1);
        this.shop.addGoods("Shelves7", goods2);
    }

    @Test
    public void testIsTrueAdd() throws OperationNotSupportedException {
        String expected = "Goods: 123 is placed successfully!";
        String actual = this.shop.addGoods("Shelves1",goods1);
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(goods1, this.shop.getShelves().get("Shelves1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConteinsKeyRemove() {
        shop.removeGoods("god",goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsValueRemove(){
        this.shop.removeGoods("Shelves1",goods2);
    }

    @Test
    public void testIsTrueRemove() throws OperationNotSupportedException {
        String expected = "Goods: 123 is removed successfully!";
        this.shop.addGoods("Shelves1",goods1);
        String actual = this.shop.removeGoods("Shelves1",goods1);
        Assert.assertEquals(expected,actual);
        Assert.assertNull(this.shop.getShelves().get("Shelves1"));
    }
}
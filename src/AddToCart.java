import java.util.Random;
public class AddToCart {
    Random random = new Random();
    public int randomNumber = random.nextInt(1,6);
    public String productNameX = "//*[@id='inventory_container']/div/div["+randomNumber+"]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a";
    public String productPriceX = "//*[@id='inventory_container']/div/div["+randomNumber+"]/div[@class='inventory_item_description']/div[@class='pricebar']/div[@class='inventory_item_price']";
    public String productBtnX = "//*[@id='inventory_container']/div/div["+randomNumber+"]/div[@class='inventory_item_description']/div[@class='pricebar']/button[@class='btn btn_primary btn_small btn_inventory ']";
    public String addToCartBtn = "//*[@id='shopping_cart_container']/a";
    public String cartProductName = "//*[@class='cart_item']/div[@class='cart_item_label']/a";
    public String cartProductPrice = "//*[@class='cart_item']/div[@class='cart_item_label']/div[@class='item_pricebar']/div[@class='inventory_item_price']";
    public String checkOutBtn = "//*[@id='checkout']";
    public AddToCart(){

    }
}

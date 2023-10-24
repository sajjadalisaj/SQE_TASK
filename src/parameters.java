import org.openqa.selenium.WebDriver;

public class parameters {
    public static String driverName = "webdriver.chrome.driver";
    public static String driverURL = "src/driver/chromedriver.exe";
    public static String siteURL = "https://www.saucedemo.com/";
    public static String expectedTitle = "Swag Labs";
    public static String userName = "standard_user";
    public static String userPassword = "secret_sauce";
    public static String ExpectedHeading = "Products";
    public static int ms = 3000;
    public static WebDriver driver;

    public static String loginbtn = "//*[@id='login-button']";

    public static String titleXpath = "//span[@class='title']";

    public static String addToCartBtn = "//*[@id='shopping_cart_container']/a";

    public static String cartProductName = "//*[@class='cart_item']/div[@class='cart_item_label']/a";


    public static String cartProductPrice = "//*[@class='cart_item']/div[@class='cart_item_label']/div[@class='item_pricebar']/div[@class='inventory_item_price']";

    public static String checkOutBtn = "//*[@id='checkout']";


    public static String firstNameX = "first-name";


    public static String firstName = "Sajjad";


    public static String lastNameX = "last-name";
    public static String lastName = "Ali";


    public static String zipCodeX = "postal-code";
    public static String zipCode = "20B-057-SE";


    public static String continueBtnX = "//*[@id='continue']";


    public static String finishBtnX = "//*[@id='finish']";


    public static String endNote = "Thank you for your order!";


    public static String endNoteX = "//*[@id='checkout_complete_container']/h2";
}

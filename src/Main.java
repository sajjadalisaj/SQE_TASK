import org.openqa.selenium.By;
import org.openqa.selenium .WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

public class Main {
    /*public static class parameters {
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


    }*/


    /*public static void waitforTime(int ms) throws Exception{
        try {
            Thread.sleep(parameters.ms);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void initiateWebBrowserSession() throws Exception{
        try {
            System.setProperty(parameters.driverName, parameters.driverURL);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            parameters.driver = new ChromeDriver(chromeOptions);
            parameters.driver.manage().window().maximize();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void navigateToURL(String url) throws Exception{
        try {
            parameters.driver.get(parameters.siteURL);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void verifyTitle(String title) throws Exception{
        try {
            String actualTitle = parameters.driver.getTitle();


            if (actualTitle.equals(parameters.expectedTitle)) {
                System.out.println("Test Passed!\nActual Title: " + actualTitle + "\nExpected Title: " + parameters.expectedTitle);
            } else {
                System.out.println("Test Failed!\nActual Title: " + actualTitle + "\nExpected Title: " + parameters.expectedTitle);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void enterText(String identifer, String testData) throws Exception{
        try{
            WebElement userNameTextBox = parameters.driver.findElement(By.id(identifer));
            userNameTextBox.sendKeys(testData);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void clickElement(String identifer) throws Exception{
        try{
            WebElement btn = parameters.driver.findElement(By.xpath(identifer));
            btn.click();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void verifyElementExpectedText(String identifier, String expectedResult) throws Exception{
        try{
            WebElement headingText = parameters.driver.findElement(By.xpath(identifier));
            String ActualHeading = headingText.getText();
            if (ActualHeading.equals(expectedResult)){
                System.out.println("Test Passed!\nActual Heading: "+ActualHeading+"\nExpected Heading: "+expectedResult);
            }
            else {
                System.out.println("Test Failed!\nActual Heading: "+ActualHeading+"\nExpected Heading: "+expectedResult);
            }


        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void closeBrowser() throws Exception{
        try{
            parameters.driver.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }*/


    public static void main(String[] args) {
        try {
            //1. Login
            System.out.println("Testing Started!!!\nLogin");
            Methods.initiateWebBrowserSession();
            Methods.navigateToURL(parameters.siteURL);
            Methods.verifyTitle(parameters.expectedTitle);
            Methods.enterText("user-name", parameters.userName);
            Methods.enterText("password", parameters.userPassword);
            Methods.clickElement(parameters.loginbtn);
            Methods.waitforTime(parameters.ms);
            System.out.println("\nInventory Page Heading!");
            Methods.verifyElementExpectedText(parameters.titleXpath,parameters.ExpectedHeading);

            //2. Add to Cart Product
            System.out.println("\nSelecting Random Product Name and Price!");
            Random random = new Random();
            int randomNumber = random.nextInt(1,6);

            WebElement productName = parameters.driver.findElement(By.xpath("//*[@id='inventory_container']/div/div["+randomNumber+"]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a"));
            String productText = productName.getText();

            WebElement priceName = parameters.driver.findElement(By.xpath("//*[@id='inventory_container']/div/div["+randomNumber+"]/div[@class='inventory_item_description']/div[@class='pricebar']/div[@class='inventory_item_price']"));
            String priceText = priceName.getText();

            System.out.println(productText);
            System.out.println(priceText);

            Methods.clickElement("//*[@id='inventory_container']/div/div["+randomNumber+"]/div[@class='inventory_item_description']/div[@class='pricebar']/button[@class='btn btn_primary btn_small btn_inventory ']");

            //3. Cart Page
            Methods.clickElement(parameters.addToCartBtn);
            System.out.println("\nVerifying Product in Cart");
            Methods.verifyElementExpectedText(parameters.cartProductName,productText);
            Methods.verifyElementExpectedText(parameters.cartProductPrice,priceText);
            Methods.waitforTime(parameters.ms);
            Methods.clickElement(parameters.checkOutBtn);

            //4. CheckOut Information
            System.out.println("\nCheckout Information");
            Methods.enterText(parameters.firstNameX, parameters.firstName);
            Methods.enterText(parameters.lastNameX, parameters.lastName);
            Methods.enterText(parameters.zipCodeX, parameters.zipCode);
            Methods.clickElement(parameters.continueBtnX);

            //5. Finalized Details
            System.out.println("\nEnd Note");
            Methods.waitforTime(parameters.ms);
            Methods.clickElement(parameters.finishBtnX);
            Methods.verifyElementExpectedText(parameters.endNoteX, parameters.endNote);

            Methods.closeBrowser();
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}

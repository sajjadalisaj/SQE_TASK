import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Main {
    public static void main(String[] args) {
        try {
            //1. Login
            System.out.println("Testing Started!!!\nLogin");
            Methods.initiateWebBrowserSession();
            Methods.navigateToURL(parameters.siteURL);
            Methods.verifyTitle(parameters.expectedTitle);

            Login login = new Login(parameters.driver);

            Methods.enterText(login.userID, login.userName);
            Methods.enterText(login.passwordId, login.userPassword);
            Methods.clickElement(login.loginbtn);

            Methods.waitforTime(parameters.ms);
            System.out.println("\nInventory Page Heading!");
            Methods.verifyElementExpectedText(parameters.titleXpath,parameters.ExpectedHeading);

            //2. Add to Cart Product
            System.out.println("\nSelecting Random Product Name and Price!");

            AddToCart addToCart = new AddToCart();

            WebElement productName = parameters.driver.findElement(By.xpath(addToCart.productNameX));
            String productText = productName.getText();

            WebElement priceName = parameters.driver.findElement(By.xpath(addToCart.productPriceX));
            String priceText = priceName.getText();

            System.out.println(productText);
            System.out.println(priceText);

            Methods.clickElement(addToCart.productBtnX);

            //3. Cart Page
            Methods.clickElement(addToCart.addToCartBtn);
            System.out.println("\nVerifying Product in Cart");
            Methods.verifyElementExpectedText(addToCart.cartProductName,productText);
            Methods.verifyElementExpectedText(addToCart.cartProductPrice,priceText);
            Methods.waitforTime(parameters.ms);
            Methods.clickElement(addToCart.checkOutBtn);

            //4. CheckOut Information

            CheckOut checkOut = new CheckOut();

            System.out.println("\nCheckout Information");
            Methods.enterText(checkOut.firstNameX, checkOut.firstName);
            Methods.enterText(checkOut.lastNameX, checkOut.lastName);
            Methods.enterText(checkOut.zipCodeX, checkOut.zipCode);
            Methods.clickElement(checkOut.continueBtnX);

            //5. Finalized Details
            System.out.println("\nEnd Note");
            Methods.waitforTime(parameters.ms);
            Methods.clickElement(checkOut.finishBtnX);
            Methods.verifyElementExpectedText(checkOut.endNoteX, checkOut.endNote);

            Methods.closeBrowser();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

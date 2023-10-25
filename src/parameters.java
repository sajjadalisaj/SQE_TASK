import org.openqa.selenium.WebDriver;
public class parameters {
    public static String driverName = "webdriver.chrome.driver";
    public static String driverURL = "src/driver/chromedriver.exe";
    public static String siteURL = "https://www.saucedemo.com/";
    public static String expectedTitle = "Swag Labs";
    public static String ExpectedHeading = "Products";
    public static int ms = 3000;
    public static WebDriver driver;
    public static String titleXpath = "//span[@class='title']";
}

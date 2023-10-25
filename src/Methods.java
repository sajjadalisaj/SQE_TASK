import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Methods {
    public static void waitforTime(int ms) throws Exception{
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
    }
}

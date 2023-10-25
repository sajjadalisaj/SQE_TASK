import org.openqa.selenium.WebDriver;
public class Login {
    public WebDriver driver;
    public String userID = "user-name";
    public String passwordId = "password";
    public String userName = "standard_user";
    public String userPassword = "secret_sauce";
    public String loginbtn = "//*[@id='login-button']";
    public Login(WebDriver driver){
        driver = this.driver;
    }
}

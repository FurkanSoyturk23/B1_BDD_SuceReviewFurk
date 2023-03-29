package com.sauce.pages;

import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    public WebElement inputUsername;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(tagName = "h3")
    public WebElement actualErrorMessage;

    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }
}

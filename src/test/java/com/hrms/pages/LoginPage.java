package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordBox;

    @FindBy(css = "input#btnLogin")
    public WebElement loginBtn;

    @FindBy(id="spanMessage")
    public WebElement errorMsg;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        sendText(usernameBox,username);
        sendText(passwordBox, password);
    }

    public void clickOnLoginBtn() {
        click(loginBtn);
    }

    public String getErrorMessageText() {
        return errorMsg.getText();
    }
}

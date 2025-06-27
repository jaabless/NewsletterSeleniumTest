package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(className = "subscribe-btn")
//    private By subscribeButton = new By.ByClassName("subscribe-btn");
    private WebElement subscribeButton;

    @FindBy(className = "error-message")
    private WebElement errorMessage;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public ConfirmationPage clickSubscribe() {
        subscribeButton.click();
        return new ConfirmationPage(driver);
    }


    public String getErrorMessage() {
        return errorMessage.getText();
    }
}

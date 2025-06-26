package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    private WebDriver driver;

    @FindBy(className = "checkmark")
    private WebElement checkmark;

    @FindBy(className = "message")
    private WebElement message;

    @FindBy(className = "subscribe-btn")
    private WebElement dismissButton;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckmarkDisplayed() {
        return checkmark.isDisplayed();
    }

    public String getConfirmationMessage() {
        return message.getText();
    }

    public void clickDismiss() {
        dismissButton.click();
    }
}
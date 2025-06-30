package com.example;

import org.example.pages.ConfirmationPage;
import org.example.pages.SignupPage;
import org.junit.jupiter.api.*;

public class NewsletterTest extends BaseTests {
    private SignupPage signupPage;
    private ConfirmationPage confirmationPage;

    @BeforeEach
    public void openSignupPage() {
        driver.get("https://shimmering-hamster-bbee86.netlify.app/");
        signupPage = new SignupPage(driver);
    }

    @Test
    public void testEmptyEmailInput() {
        signupPage.enterEmail("");
        signupPage.clickSubscribe();
        Assertions.assertEquals("Email is required", signupPage.getErrorMessage(),
                "Error message should be displayed for empty email");
    }

    @Test
    public void testInvalidEmailShowsError() {
        signupPage.enterEmail("invalid-email");
        signupPage.clickSubscribe();
        Assertions.assertEquals("Valid email required", signupPage.getErrorMessage(),
                "Error message should be displayed for invalid email");
    }

    @Test
    public void testValidEmailInput() {
        signupPage.enterEmail("test@example.com");
        signupPage.clickSubscribe();
        confirmationPage = new ConfirmationPage(driver);
        Assertions.assertTrue(confirmationPage.getConfirmationMessage().contains("Thanks for subscribing!"),
                "Confirmation message should be displayed");
    }

    @Test
    public void testConfirmationCheckmarkDisplayed() {
        signupPage.enterEmail("test@example.com");
        signupPage.clickSubscribe();
        confirmationPage = new ConfirmationPage(driver);
        Assertions.assertTrue(confirmationPage.isCheckmarkDisplayed(),
                "Confirmation checkmark should be displayed");
    }

    @Test
    public void testConfirmationMessageContent() {
        signupPage.enterEmail("test@example.com");
        signupPage.clickSubscribe();
        confirmationPage = new ConfirmationPage(driver);
        Assertions.assertTrue(confirmationPage.getConfirmationMessage().contains("Thanks for subscribing!"),
                "Confirmation message should contain correct text");
    }

    @Test
    public void testDismissReturnsToSignupPage() {
        signupPage.enterEmail("test@example.com");
        signupPage.clickSubscribe();
        confirmationPage = new ConfirmationPage(driver);
        confirmationPage.clickDismiss();
        Assertions.assertTrue(driver.getTitle().contains("Newsletter Signup") ||
                        driver.getPageSource().contains("Stay updated!"),
                "Should return to signup page after dismiss");
    }
}

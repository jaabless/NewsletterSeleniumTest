package com.example;

import org.example.pages.ConfirmationPage;
import org.example.pages.SignupPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
public class NewsletterTest {
    private static WebDriver driver;
    private static SignupPage signupPage;
    private ConfirmationPage confirmationPage;

    @BeforeAll
    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://shimmering-hamster-bbee86.netlify.app/");
//        driver.get("file:\\\"C:\\Users\\USER\\Desktop\\CODE\\JAVA\\GTP LABS\\QA\\Newsletter\\index.html\"");
        signupPage = new SignupPage(driver);
    }

//    @BeforeEach
//    public void openSignupPage() {
//        driver.get("https://shimmering-hamster-bbee86.netlify.app/");
////        driver.get("file:\\\"C:\\Users\\USER\\Desktop\\CODE\\JAVA\\GTP LABS\\QA\\Newsletter\\index.html\"");
//        signupPage = new SignupPage(driver);
//    }

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
        Assertions.assertEquals("Valid email required", signupPage.getErrorMessage(), "Error message should be displayed for invalid email");
    }

    @Test
    public void testValidEmailInput() {
        signupPage.enterEmail("test@example.com");
        signupPage.clickSubscribe();

        // Wait for navigation or JS update here if needed
        confirmationPage = new ConfirmationPage(driver);
        Assertions.assertTrue(confirmationPage.getConfirmationMessage().contains("Thanks for subscribing!"),"Confirmation message should be displayed");
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

        // Check if we're back on the signup page by asserting the title or an element
        Assertions.assertTrue(driver.getTitle().contains("Newsletter Signup") ||
                        driver.getPageSource().contains("Stay updated!"),
                "Should return to signup page after dismiss");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
package org.example;

import org.openqa.selenium.*;

public class loginPage {

    private WebDriver driver;
    private By acceptCookiesButton = By.xpath("//button[@data-cookiebanner='accept_button']");
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='pass']");
    private By loginButton = By.xpath("//button[@name='login']");

    private By profileLocator = By.xpath("//a[contains(@href,'profile')][1]");

    private By profilePicture = By.xpath("//*[@aria-label='Your profile']");
    private By logoutButton = By.xpath("//span[text()='Log Out']");

    public loginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://facebook.com/login");
    }

    public void acceptCookies() {
        try {
            WebElement acceptCookies = driver.findElement(acceptCookiesButton);
            acceptCookies.click();
        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
            //System.out.println("No cookies to accept");
        }
    }

    public void enterEmailAndPassword(String email, String password) {
        try {
            driver.findElement(emailField).sendKeys(email);
            driver.findElement(passwordField).sendKeys(password);
        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
        }
    }

    public void clickLoginButton() {
        try {
            driver.findElement(loginButton).click();
        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
        }
    }

    // Check if the login is successful
    public void isLoginSuccessful() {
        try {
            driver.findElement(profileLocator).isDisplayed();
        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
        }
    }

    public void logout() {
        try {

            WebElement profile = driver.findElement(profilePicture);
            profile.click();

            utils.delay(2000);

            WebElement logout = driver.findElement(logoutButton);
            logout.click();

            utils.delay(2000);


        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
        }
    }


}

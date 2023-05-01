package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class postPage {

    private WebDriver driver;
    private By createPostBTN = By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']");
    private By postField = By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']");
    private By postBTN = By.xpath("//div[@aria-label='Post']");

    public postPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createPost(String post) throws InterruptedExceptigioon {
        WebElement createButton = driver.findElement(createPostBTN);
        createButton.click();

        utils.delay(4000);

        WebElement postFieldElement = driver.findElement(postField);
        postFieldElement.click();
        utils.delay(4000);
        postFieldElement.sendKeys(post);
        utils.delay(4000);
    }

    public void clickPostButton() {
        WebElement postButton = driver.findElement(postBTN);
        postButton.click();
    }

    public void navigateToProfilePage() {
        driver.get("https://www.facebook.com/profile.php");
    }

    public boolean isPostSuccessful(String givenPost) {
        try {
            // Check if the post is visible on the profile page
            utils.delay(2000);
            WebElement post = driver.findElement(By.xpath("//div[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x1vvkbs' and contains(text(), '" + givenPost + "')]"));
            return post.isDisplayed();
        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
            return false;
        }
    }

}



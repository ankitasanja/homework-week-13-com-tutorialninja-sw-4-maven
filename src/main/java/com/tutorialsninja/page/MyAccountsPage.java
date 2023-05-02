package com.tutorialsninja.page;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.UUID;

public class MyAccountsPage extends Utility {

    By options = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a");
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By registerAccount = By.xpath("//h1[contains(text(),'Register Account')]");
    By returningCustomer = By.xpath("//h2[normalize-space()='Returning Customer']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By yesRadioButton = By.xpath("//label[normalize-space()='Yes']");
    By privacyPolicy = By.xpath("//input[@name='agree']");
    By continueButton = By.xpath("//input[@value='Continue']");
    By accountText = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By continueTab = By.xpath("//a[normalize-space()='Continue']");
    By myAccountTab = By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']");
    By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continue1 = By.xpath("//a[contains(text(),'Continue')]");
    By loginButton = By.xpath("//input[@value='Login']");
    By myAccountText = By.xpath("//h2[normalize-space()='My Account']");
    By myAccountLink = By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']");
    By textAccountLogout = By.xpath("//h1[normalize-space()='Account Logout']");
    By continue2 = By.xpath("//a[normalize-space()='Continue']");

    public void selectMyOptions(String option) {

        clickOnElement(By.linkText("My Account"));
        List<WebElement> optionsList = driver.findElements(options);
        for (WebElement element : optionsList) {
            if (element.getText().equalsIgnoreCase(option)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccount);
    }

    public String verifyTextRegisterAccount() {
        return getTextFromElement(registerAccount);
    }

    public String verifyTextReturningCustomer() {
        return getTextFromElement(returningCustomer);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        sendTextToElement(lastName, lName);
    }

    public void enterEmailId() {
        String randomEmail = randomEmail();
        sendTextToElement(email, randomEmail);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    public void enterTelephone(String telNum) {
        sendTextToElement(telephone, telNum);
    }

    public void enterPassword(String passWord) {
        sendTextToElement(password, passWord);
    }

    public void enterConfirmPassword(String conPassword) {
        sendTextToElement(confirmPassword, conPassword);
    }

    public void clickOnYesRadioButton() {
        clickOnElement(yesRadioButton);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public String verifyMessageAccountCreated() {
        return getTextFromElement(accountText);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
    }

    public String verifyTextAccountLogout() {
        return getTextFromElement(accountLogoutText);
    }

    public void clickOnContinue() {
        clickOnElement(continue1);
    }

    public void enterEmail(String emailId) {
        sendTextToElement(email, emailId);
    }

    public void enterPasswordField(String passwordField) {
        sendTextToElement(password, passwordField);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String verifyTextMyAccount() {
        return getTextFromElement(myAccountText);
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccountLink);
    }

    public String getTextAccountLogout() {
        return getTextFromElement(textAccountLogout);
    }

    public void clickOnContinueLink() {
        clickOnElement(continue2);
    }


}

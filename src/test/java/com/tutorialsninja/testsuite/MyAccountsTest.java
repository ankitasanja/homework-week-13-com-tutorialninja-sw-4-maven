package com.tutorialsninja.testsuite;

import com.tutorialsninja.page.MyAccountsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {
    MyAccountsPage accountsPage = new MyAccountsPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        accountsPage.selectMyOptions("Register");
        String expectedText = "Register Account";
        String actualText = accountsPage.verifyTextRegisterAccount();
        Assert.assertEquals(actualText, expectedText, "Error found");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        accountsPage.selectMyOptions("Login");
        String expectedText = "Returning Customer";
        String actualText = accountsPage.verifyTextReturningCustomer();
        Assert.assertEquals(actualText, expectedText, "Error found");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        accountsPage.selectMyOptions("Register");
        accountsPage.enterFirstName("Magnus");
        accountsPage.enterLastName("Smith");
        accountsPage.enterEmailId();
        accountsPage.enterTelephone("9825655114");
        accountsPage.enterPassword("smith123456");
        accountsPage.enterConfirmPassword("smith123456");
        accountsPage.clickOnYesRadioButton();
        accountsPage.clickOnPrivacyPolicyCheckBox();
        accountsPage.clickOnContinueButton();
        String expectedText = "Your Account Has Been Created!";
        String actualText = accountsPage.verifyMessageAccountCreated();
        Assert.assertEquals(actualText, expectedText, "Error message");
        accountsPage.clickOnContinueTab();
        accountsPage.clickOnMyAccountTab();
        accountsPage.selectMyOptions("Logout");
        String expectedMessage = "Account Logout";
        String actualMessage = accountsPage.verifyTextAccountLogout();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message");
        accountsPage.clickOnContinue();

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        accountsPage.selectMyOptions("Login");
        accountsPage.enterEmail("magnussmith123@gmail.com");
        accountsPage.enterPasswordField("smith123456");
        accountsPage.clickOnLoginButton();
        String expectedText = "My Account";
        String actualText = accountsPage.verifyTextMyAccount();
        Assert.assertEquals(actualText, expectedText, "Error message");
        accountsPage.clickOnMyAccount();
        accountsPage.selectMyOptions("Logout");
        String expectedMessage = "Account Logout";
        String actualMessage = accountsPage.getTextAccountLogout();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message");
        accountsPage.clickOnContinueLink();
    }
}

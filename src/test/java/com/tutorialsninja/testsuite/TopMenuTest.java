package com.tutorialsninja.testsuite;

import com.tutorialsninja.page.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        // Verify the text 'Desktops'
        String expectedText = "Desktops";
        String actualText = homePage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopAndNotebooksLinkAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        // Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = homePage.getLaptopsAndNotebooksText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Laptops & Notebooks page");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsLinkAndClick();
        homePage.selectMenu("Show AllComponents");
        // Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = homePage.getComponentsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to components page");
    }
}

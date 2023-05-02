package com.tutorialsninja.testsuite;

import com.tutorialsninja.page.DesktopsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class DesktopsTest extends BaseTest {
    DesktopsPage desktopsPage = new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        desktopsPage.mouseHoverOnDesktopLinkAndClick();
        desktopsPage.clickOnShowAllDesktops();
        // Get all the products name and sorted into arrayList

        desktopsPage.selectPositionByZtoA();
        //Verify the Product will arrange in Descending order.
        ArrayList<String> actualList = getArrayListOfStringsFromWebElements(desktopsPage.returnZtoAElementsLocator());
        ArrayList<String> expectedList = getArrayListOfStringsFromWebElements(desktopsPage.returnZtoAElementsLocator());

        Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(expectedList);
        Assert.assertEquals(actualList, expectedList, "Error message: Products are not displayed in alphabetical order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        desktopsPage.mouseHoverOnDesktopLinkAndClick();
        desktopsPage.clickOnShowAllDesktops();
        desktopsPage.selectPositionByAtoZ();
        //2.4 Select product “HP LP3065
        desktopsPage.clickOnProductHPLP3065();
        // 2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = desktopsPage.getTextHPLP3065();
        Assert.assertEquals(actualText, expectedText, "Error found");
        // 2.6 Select Delivery Date "2022-11-30"
        desktopsPage.selectDateFromCalender();
        // 2.7.Enter Qty "1” using Select class.
        desktopsPage.enterQuantity();
        // 2.8 Click on “Add to Cart” button
        desktopsPage.clickOnAddToCart();
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!";
        String actualText1 = desktopsPage.getSuccessText();
        boolean message = actualText1.contains(expectedText1.trim());
        Assert.assertTrue(message);

        // 2.10 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCart();
        // 2.11 Verify the text "Shopping Cart"
        String expectedMessage = "Shopping Cart  (1.00kg)";
        String actualMessage = desktopsPage.getShoppingCartText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error found");
        // 2.12 Verify the Product name "HP LP3065"
        String expectedMessage1 = "HP LP3065";
        String actualMessage1 = desktopsPage.getProductNameHPLPText();
        Assert.assertEquals(actualMessage1, expectedMessage1, "Error found");
        // 2.13 Verify the Delivery Date "2022-11-30"
        String expectedMessage2 = "Delivery Date:2023-11-30";
        String actualMessage2 = desktopsPage.verifyDeliveryDate();
        Assert.assertEquals(actualMessage2, expectedMessage2, "Error found");
        // 2.14 Verify the Model "Product21"
        String expectedMessage3 = "Product 21";
        String actualMessage3 = desktopsPage.verifyModelProduct21();
        Assert.assertEquals(actualMessage3, expectedMessage3, "Error found");
        // 2.15 Verify the Todat "£74.73"
        String expectedTotal = "$122.00";
        String actualTotal = desktopsPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Error found");
    }
}

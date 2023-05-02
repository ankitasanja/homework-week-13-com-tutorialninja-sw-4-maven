package com.tutorialsninja.page;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsPage extends Utility {

    By desktopLink = By.linkText("Desktops");
    By showAllDesktops = By.linkText("Show AllDesktops");
    By positionZtoA = By.id("input-sort");
    By allProductsName = By.xpath("//h4/a");
    By positionAtoZ = By.id("input-sort");
    By HP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By textHPLP3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By calender = By.xpath("//div[@class = 'input-group date']//button");


    By monthYear= By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");

    By yearAndMonth = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");


    By day= By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By quantity = By.xpath("//input[@id='input-quantity']");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By productHPLp3065 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By product21 = By.xpath("//td[normalize-space()='Product 21']");
    By totalPrice = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    public void mouseHoverOnDesktopLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
    }

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDesktops);
    }

    public void selectPositionByZtoA() {
        selectByVisibleTextFromDropDown(positionZtoA,"Name (Z - A)");
    }

    public List<WebElement> returnZtoAElementsLocator() {
        List<WebElement> listOfElements = driver.findElements(allProductsName);
        return listOfElements;
    }

    public void selectPositionByAtoZ() {
        selectByVisibleTextFromDropDown(positionAtoZ,"Name (A - Z)");
    }
    public void clickOnProductHPLP3065() {
        clickOnElement(HP3065);
    }

    public String getTextHPLP3065(){
        return getTextFromElement(textHPLP3065);
    }

    public void selectDateFromCalender() {

        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(calender);
        while (true) {
            String monthAndYear = driver.findElement(monthYear).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(yearAndMonth);
            }
        }
        List<WebElement> allDates = driver.findElements(day);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void enterQuantity() {
        sendTextToElement(quantity,"");
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }
    public String getSuccessText() {
        return getTextFromElement(successMessage);
    }
    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }
    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }
    public String getProductNameHPLPText() {
        return getTextFromElement(productHPLp3065);
    }
    public String verifyDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }
    public String verifyModelProduct21() {
        return getTextFromElement(product21);
    }
    public String verifyTotal() {
        return getTextFromElement(totalPrice);
    }







}

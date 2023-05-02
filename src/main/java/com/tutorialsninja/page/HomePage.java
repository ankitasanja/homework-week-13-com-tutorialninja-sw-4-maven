package com.tutorialsninja.page;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopLink = By.linkText("Desktops");
    By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooksLink = By.linkText("Laptops & Notebooks");
    By laptopAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By componentsLink = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenu);
        }
    }

    public void mouseHoverOnDesktopLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
    }

    public String getDesktopsText() {
        return getTextFromElement(desktopsText);
    }

    public void mouseHoverOnLaptopAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(laptopAndNotebooksText);
    }

    public void mouseHoverOnComponentsLinkAndClick() {
        mouseHoverToElementAndClick(componentsLink);
    }

    public String getComponentsText() {
        return getTextFromElement(componentsText);
    }


}

package org.mfti.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpPetsElement {
    private WebDriver driver = null;

    public HelpPetsElement(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".pets-dobro")
    private WebElement component;
    @FindBy(css= ".pets-dobro .pypo-item__title")
    List <WebElement> dobroItemsTitles;

    private final String petsDobroItemLocator = "//*[contains(@class, 'pets-dobro)]/*[contains(@class, 'pypo-item__title')]";
    private final String petsDobroItemTitleLocator = petsDobroItemLocator+"";
    public boolean isComponentPresent() {
        return component.isDisplayed();
    }


}

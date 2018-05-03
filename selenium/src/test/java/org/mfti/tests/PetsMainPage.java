package org.mfti.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetsMainPage extends BasePage {
    public PetsMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String PageURL = System.getProperty("domain.url")+"/";
    private WebDriver driver = null;
    public PetsMainPage open() {
        return ;
    }
}

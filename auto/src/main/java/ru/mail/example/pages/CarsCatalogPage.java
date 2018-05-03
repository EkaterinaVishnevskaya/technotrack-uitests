package ru.mail.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.mail.example.data.MinMaxData;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Страница "Милота" с реализацией PageObject паттерна
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
@Page("/catalog")
@UrlPattern("catalog")
public class CarsCatalogPage extends AbstractPage {

    public CarsCatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageHeader() {
        return "Каталог";
    }
//    @FindBy(css = "[name=\"min_price\"]")
//    private WebElement minPriceInput;
//
//    @FindBy(css = "[name=\"max_price\"]")
//    private WebElement maxPriceInput;

    private String minPriceINputSelector = "[name='%s_price']";

    @FindBy(css = ".button_color_project")
    private WebElement button;

//    public void setMinPriceInput (Integer x) {
//        minPriceInput.sendKeys(x.toString());
//    }

    public void setPriceInput (MinMaxData minMaxData, Integer x) {
        String selector = String.format(minPriceINputSelector, minMaxData.name());
        getDriver().findElement(By.cssSelector(selector)).sendKeys(x.toString());
    }

    public void filter() {
        Actions actions = new Actions(getDriver());
        actions.click(button);
    }

    public String getPriceInput(MinMaxData minMaxData) {
        String selector = String.format(minPriceINputSelector, minMaxData.name());
        return getDriver().findElement(By.cssSelector(selector)).getText();
    }

//    public String getMaxPriceInput() {
//        return maxPriceInput.getText();
//    }
    /*@FindBy(css = ".pypo-item__title")
    private List<WebElement> articlesTitles;

    *//**
     * Возвращает названия статей на странице
     * @return названия статей
     *//*
    public List<String> getAllArticlesTitles() {
        return articlesTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    *//**
     * Проверяет, что список статей на странице изменился
     * @param titles - названия статей
     * @return boolean
     *//*
    public boolean isArticlesTitlesChanged(List<String> titles) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getAllArticlesTitles() != titles;
            }
        };
        return waitTools.waitForCondition(condition);
    }*/
}
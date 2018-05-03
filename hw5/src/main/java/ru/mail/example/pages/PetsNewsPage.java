package ru.mail.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.mail.example.navigation.Page;
import ru.mail.example.navigation.UrlPattern;

import java.util.List;
import java.util.stream.Collectors;

@Page("/news")
@UrlPattern("news")
public class PetsNewsPage extends AbstractPage {

    public PetsNewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".js-pgng_more_link")
    private WebElement moreButton;

    @FindBy(css = ".pypo-item__title")
    private List<WebElement> articlesTitles;

    public List<String> getAllArticlesTitles() {
        return articlesTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public WebElement getMoreButton() {
        return moreButton;
    }

    public boolean isArticlesTitlesChanged(List<String> titles) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getAllArticlesTitles() != titles;
            }
        };
        return waitTools.waitForCondition(condition);
    }
}
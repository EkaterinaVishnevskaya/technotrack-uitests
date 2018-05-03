package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.pages.PetsNewsPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetsNewsPageSteps extends AbstractSteps {

    private PetsNewsPage petsNewsPage = null;

    public PetsNewsPageSteps(WebDriver driver) {
        super(driver);
        petsNewsPage = PageFactory.initElements(driver, PetsNewsPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                petsNewsPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        petsNewsPage.open();
        petsNewsPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Кликаем по кнопке \"Показать ещё\"")
    public void clickMoreButton() {
        petsNewsPage.getMoreButton().click();
    }

    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return petsNewsPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице изменился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                petsNewsPage.isArticlesTitlesChanged(titles));
    }
}

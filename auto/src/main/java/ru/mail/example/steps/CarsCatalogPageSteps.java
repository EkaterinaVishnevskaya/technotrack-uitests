package ru.mail.example.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.example.data.MinMaxData;
import ru.mail.example.pages.CarsCatalogPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Набор шагов для взаимодействия со страницей "Милота"
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
public class CarsCatalogPageSteps extends AbstractSteps {

    private CarsCatalogPage carsCatalogPage = null;

    public CarsCatalogPageSteps(WebDriver driver) {
        super(driver);
        carsCatalogPage = PageFactory.initElements(driver, CarsCatalogPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                carsCatalogPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        carsCatalogPage.open();
        carsCatalogPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Устанавливаем ценовой диапазон")
    public void setPrice(Integer min, Integer max){
        carsCatalogPage.setPriceInput(MinMaxData.min, min);
        carsCatalogPage.setPriceInput(MinMaxData.max, max);
        assertEquals(min.toString(), carsCatalogPage.getPriceInput(MinMaxData.min));
        assertEquals(max.toString(), carsCatalogPage.getPriceInput(MinMaxData.max));
        carsCatalogPage.filter();
    }

/*    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return carsCatalogPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице изменился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                carsCatalogPage.isArticlesTitlesChanged(titles));
    }*/
}

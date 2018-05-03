package ru.mail.example;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.example.driver.DriverProvider;
import ru.mail.example.steps.PetsNewsPageSteps;

import java.util.List;

@DisplayName("Проверяем клил по кнопке \"Показать ещё\" проекта \"Питомцы\"")
public class ClickMorePetsNews_Test {

    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void click_more_button_pets_news() {

        //Открываем страницу "Новости"
        PetsNewsPageSteps petsNewsPageSteps = new PetsNewsPageSteps(driverProvider.getDriver());
        petsNewsPageSteps.open("Новости");


        //Получаем названия всех статей на странице
        List<String> titles = petsNewsPageSteps.getAllArticlesTitles();

        //Кликаем по кнопке "Показать ещё"
        petsNewsPageSteps.clickMoreButton();

        //Проверяем, что список статей на странице изменился
        petsNewsPageSteps.articlesTitlesShouldBeChanged(titles);
    }
}
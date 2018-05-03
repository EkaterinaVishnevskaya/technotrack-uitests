package org.mfti.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Test {

    private WebDriver driver;

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-error");

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void close() {
        if(driver!=null){
            driver.quit();
        }
    }

    @org.junit.Test
    public void click_article_title() {
        driver.get("https://pets.mail.ru");

        boolean f = false;
        try {
            WebElement textEdit = driver.findElement(By.id("lst-ib"));
            textEdit.sendKeys( );
            f=true;
        }
        catch (Exception ignored) {

        }
        assertTrue(f);
    }

}

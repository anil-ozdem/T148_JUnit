package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_WindowDegistirme extends TestBaseEach {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();

        // acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver, "https://elementalselenium.com/");

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        // ilk window'a geri donun
        ReusableMethods.urlIleWindowDegistir(driver, "https://the-internet.herokuapp.com/windows");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        driver.findElement(By.tagName("h3")).isDisplayed();

        // Click here'a basin
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        // Acilan yeni window'a gecip, oradaki yazinin "New Window" oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver, "https://the-internet.herokuapp.com/windows/new");

        expectedYazi = "New Window";
        actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // Elemental selenium'un acik oldugu window'a gecip
        // Tips linkinin erisilebilir oldugunu test edin

        ReusableMethods.urlIleWindowDegistir(driver, "https://elementalselenium.com/");
        WebElement tipsElementi = driver.findElement(By.xpath("//*[text()='Tips']"));

        Assertions.assertTrue(tipsElementi.isEnabled());


    }

}

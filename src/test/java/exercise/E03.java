package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class E03 extends TestBaseEach {

    @Test
    public void test01(){

        //https://testotomasyonu.com/click sayfasına gidin.
        driver.get("https://testotomasyonu.com/click");
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //double click ve don't release me yazılarının görünürlülüğünü kontrol ediniz.
        WebElement doubleClickButton = driver.findElement(By.id("btn1"));
        WebElement dontRelaseMeButton = driver.findElement(By.id("btn2"));

        Assertions.assertTrue(doubleClickButton.isDisplayed());
        Assertions.assertTrue(dontRelaseMeButton.isDisplayed());

        //Double click' üzerine çift tıkla ve renginin değiştiğini kontrol et.

        actions.doubleClick(doubleClickButton).perform();

        WebElement basiliDoubleClick = driver.findElement(By.className("mystyle"));

        Assertions.assertTrue(basiliDoubleClick.isDisplayed());
        ReusableMethods.bekle(1);

        //don't release me üzerine gel ve basılı tut. Well done yazısının görünür olduğunu kontrol ediniz.
        actions.clickAndHold(dontRelaseMeButton).perform();
        WebElement wellDoneYazisi = driver.findElement(By.xpath("//*[.='Well done!.....']"));


        Assertions.assertTrue(wellDoneYazisi.isDisplayed());

    }
}

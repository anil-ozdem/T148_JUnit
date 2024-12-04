package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_Actions_ContextClick extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement dgiDrones = driver.findElement(By.id("pic2_thumb"));

        ReusableMethods.bekle(1);
        actions.contextClick(dgiDrones).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazi = driver
                                       .switchTo()
                                       .alert()
                                       .getText();

        Assertions.assertEquals(expectedAlertYazi, actualAlertYazi);

        //4- Tamam diyerek alert’i kapatalim

        driver
                .switchTo()
                .alert()
                .accept();
    }
}
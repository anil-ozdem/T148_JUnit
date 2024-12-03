package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_IFrame extends TestBaseEach {

    @Test
    public void test01() {

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // electronics products yazisini unique olarak locate etmemize ragmen kullanamadik
        // HTML kodlari inceleyince kull;anmak istedigimiz webelementin
        // bir iframe(gomulu HTML sayfa) icerisinde oldugunu belirledik
        // bir iframe icerisindeki elementi kullanabilmek icin
        // once o iframe'e gecis yapmamiz gerekir


        WebElement electronicsIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframeElementi);

        WebElement electronicsProductsYaziElementi =
                driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElementi = driver.findElement(By.id("pictext1"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        //4- Sale Up To 50% yazisinin gorunur oldugunu test edin

        // iframe icine gecis yapinca , biz driver'i oradan cikarincaya kadar
        // driver iframe'in icinde kalir
        // driver'i icinde oldugu iFrame'den cikarmak icin

        //driver.switchTo().parentFrame();
        // ic ice birden fazla katman olarak iFrame'ler varsa
        // bir ust katman'a cikartir

        driver.switchTo().defaultContent();
        // ic ice birden fazla katman olarak iFrame'ler varsa
        // direk anasayfaya cikartir

        WebElement saleUpYaziElementi = driver.findElement(By.xpath("//*[text()='Sale Up To 50%']"));

        Assertions.assertTrue(saleUpYaziElementi.isDisplayed());


        ReusableMethods.bekle(3);
    }
}
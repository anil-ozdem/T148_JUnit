package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class E02 extends TestBaseEach {

    @Test
    public void test01() {

        // 1-https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur oldugunu test edin
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);
        WebElement electronicsProductsText = driver.findElement(By.xpath("//*[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsText.isDisplayed());

        // 3- Dell bilgisayar urun isminin 'DELL Core I3 11th Gen' oldugunu test edin

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[.='DELL Core I3 11th Gen ']")).getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        // 4- Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        WebElement dellBilgisayar = driver.findElement(By.id("pic1_thumb"));
        dellBilgisayar.click();

        ReusableMethods.urlIleWindowDegistir(driver,"https://testotomasyonu.com/product/58");
        String expectedUrunFiyati = "$399.00";
        String actualUrunFiyati = driver.findElement(By.xpath("//*[.='$399.00']")).getText();

        Assertions.assertEquals(expectedUrunFiyati,actualUrunFiyati);

        // 5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver,"https://testotomasyonu.com/discount");
        WebElement fashionFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionFrame);
        WebElement fashionText = driver.findElement(By.xpath("//*[.='Fashion']"));

        Assertions.assertTrue(fashionText.isDisplayed());

    }
}

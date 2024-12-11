package day12_excel_getScreenshot_jsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshotTumSayfa extends TestBaseEach {

    @Test
    public void test01() throws IOException {

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = sonucYaziElementi.getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu, actualAramaSonucu);
        ReusableMethods.bekle(1);

        // tum sayfanin secreenshot'ini alin

        // 1.adim tss objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/tumSayfaScreenShot.jpeg");


        // 3.adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya, asilResim);

        ReusableMethods.bekle(2);

    }
}

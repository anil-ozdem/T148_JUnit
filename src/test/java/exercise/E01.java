package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class E01 extends TestBaseEach {

    @Test
    public void test01() {

        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://www.testotomasyonu.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String firstWh = driver.getWindowHandle();

        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitle = "Otomasyon";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        //● Sayfa title’nin “Wise” icerdigini test edin
        expectedTitle = "Wise";
        actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        expectedTitle = "Walmart";
        actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));


    }
}

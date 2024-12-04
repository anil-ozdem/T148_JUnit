package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseEach;

public class C01_KontrolluWindowDegistirme extends TestBaseEach {

    @Test
    public void test01() {

        // test otomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // whd'ini degerini kaydedin ve yazdirin
        String testOtomasyonuWhd = driver.getWindowHandle();
        System.out.println("Test otomasyonu whd : " + testOtomasyonuWhd);


        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // whd'ini degerini kaydedin ve yazdirin
        String wisequarterWhd = driver.getWindowHandle();
        System.out.println("Wisequarter whd : " + wisequarterWhd);

        // yeni bir window acarak, arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");


        // whd'ini degerini kaydedin ve yazdirin
        String arabamWhd = driver.getWindowHandle();
        System.out.println("Arabam whd : " + arabamWhd);

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin

        /*
            Eger testimiz sirasinda birden fazla window aciliyorsa
            driver'i istedigimiz window'a gecirmek icin
            window hedef window'un WindowHandle degerini girmeliyiz
         */

        driver.switchTo().window(wisequarterWhd);
        String expectedUrlIcerik = "wisequarter";
        String actualUrlIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        // testotomasyonu'nun acik oldugu window'a donun
        // ve url'in testotomasyonu icerdigini test edin

        driver.switchTo().window(testOtomasyonuWhd);
        expectedUrlIcerik = "testotomasyonu";
        actualUrlIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));



    }
}

package day05_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C08_BeforeVeAfterSartMi {


    // tek test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    WebDriver driver;

    /*
        Verilen gorev tek bir test method'u ile yapilacak bir gorev olsa da

        Webdriver'i olusturma ve kapatma islemini ayri bir setup() ve teardown() ile
        yapmayi tercih ederiz

        Eger tek bir test method'unun icinde
        Webdriver olusturma ve sonunda driver'i kapatma islemlerini yaparsak
        Test failed oldugunda exception olustugu icin
        kodun calismasi durur ve son satirdaki driver.quit() calismaz

        ozellikle toplu calistirmalarda
        kapanmayan browser'larin olmasi
        guzel olmaz

     */

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void urunTesti() {
        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        //    Url'in testotomasyonu icerdigini test edin
        ReusableMethods.bekle(2);
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik), "Url beklendigi gibi degil");

        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(2);
        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        Assertions.assertTrue(actualBulunanUrunSayisi > 0, "Arama sonucunda urun bulunamadi");

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();
        ReusableMethods.bekle(2);
        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik), "Urun ismi phone icermiyor");

    }

}
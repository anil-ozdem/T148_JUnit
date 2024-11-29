package day05_jUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C06_Assertions {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin


    /*
        JUnit bir test method'unun
        PASSED veya FAILED olmasina
        kodlarin sorunsuz olarak calisip bitip bitmemesine gore karar verir

        Biz if-else ile test yaparsak
        if else FAILED yazdirsa bile
        kodlar problem olmadan calismaya devam ettigi icin
        method'un sonunda JUnit test PASSED olarak algilar
        ve yesil tik koyar

        Ozellikle toplu test calistirmalarda
        konsolu inceleyip
        birsuru yazi arasinda
        Test PASSED veya test FAILED sonucunu aramak
        ve kac testin failed oldugunu hesaplamak
        neredeyse imkansizdir

        Eger if ile test yapiyorsak
        ve failed oldugunda JUnit'in de bunu algilamasini istiyorsak
        throw keyword'u ile kontrollu olarak exception olusturabiliriz
     */
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // anasayfaTesti
        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        //    Url'in testotomasyonu icerdigini test edin
        ReusableMethods.bekle(2);
        String expectedUrlIcerik = "testotomasyonu1";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Anasayafa testi PASSED");
        } else {
            System.out.println("Anasayafa testi FAILED");
            throw new RuntimeException("actualUrl expectedUrl'den farkli ");
        }
    }

    @Test
    public void test02() {
        //urunAramaTesti
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(2);
        //    ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi > 10) {
            System.out.println("Urun bulma testi PASSED");
        } else {
            System.out.println("Urun bulma testi FAILED");
            throw new RuntimeException("Urun bulunamadi");
        }

    }

    @Test
    public void test03() {
        //ilkUrunIsimTesti
        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();
        ReusableMethods.bekle(2);
        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phonexxxxxx";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        if (actualUrunIsmi.contains(expectedIsimIcerik)) {
            System.out.println("Ilk urun isim testi PASSED");
        } else {
            System.out.println("Ilk urun isim testi FAILED");
            throw new RuntimeException("Ilk urun ismi expected kelimeyi icermiyor");
        }

    }
}
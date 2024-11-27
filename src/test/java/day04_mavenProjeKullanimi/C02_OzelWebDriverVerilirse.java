package day04_mavenProjeKullanimi;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_OzelWebDriverVerilirse {

    public static void main(String[] args) {

        // sirket tarafindan verilen Webdriver'i kullanarak
        // asagidaki testi yapin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();


        // acilan ilk urun sayfasindaki urun isminde
        // case sensitive olmadan "phone" gectigini test edin

        WebElement ilkUrunisimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsimIcerik = ilkUrunisimElementi.getText().toLowerCase();
        // case sensitive olmamasi icin kucuk harfe cevirelim

        if (actualUrunIsimIcerik.contains(expectedUrunIsimIcerik)) {
            System.out.println("Ilk urun isim testi PASSED");
        } else System.out.println("Ilk urun isim testi FAILED");


        // sayfayi kapatin
        ReusableMethods.bekle(2);
        driver.quit();
    }
}

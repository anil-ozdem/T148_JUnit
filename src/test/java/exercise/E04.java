package exercise;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class E04 extends TestBaseEach {


    @Test
    public void test01() {

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headersIsimleri = driver.findElements(By.xpath("//*[@role='columnheader']"));
        System.out.println(ReusableMethods.stringListeyeDonustur(headersIsimleri));

        //3. 3.sutunun basligini yazdirin
        System.out.println(headersIsimleri.get(2).getText());

        //4. Tablodaki tum datalari yazdirin ve data sayısının 70 olduğunu kontrol edin.
        List<WebElement> tumDatalar = driver.findElements(By.xpath("//*[@role='gridcell']"));
        System.out.println(ReusableMethods.stringListeyeDonustur(tumDatalar));

        int expectedDataSayisi = 70;
        int actualDataSayisi = tumDatalar.size();

        Assertions.assertEquals(expectedDataSayisi, actualDataSayisi);

        //4.5 Tabloya yeni değer ataması yapın
        driver.findElement(By.xpath("//*[@id='addNewRecordButton']")).click();
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        ReusableMethods.bekle(1);

        WebElement firstNameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));
        actions.click(firstNameKutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys("33")
                .sendKeys(Keys.TAB).sendKeys("5000")
                .sendKeys(Keys.TAB).sendKeys("QA").perform();
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        ReusableMethods.bekle(2);


        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        tumDatalar = driver.findElements(By.xpath("//*[@role='gridcell']"));
        int bosOlmayanData = 0;

        String unExpectedData = "";
        for (WebElement webElement : tumDatalar) {
            String eachData = webElement.getText();

            if (!eachData.replaceAll("\\s", "").equals(unExpectedData)) {
                bosOlmayanData++;
            }
        }

        List<WebElement> actionButtons = driver.findElements(By.xpath("//*[@class='action-buttons']"));
        int actionButtonSayisi = actionButtons.size();
        bosOlmayanData += actionButtonSayisi;
        System.out.println(bosOlmayanData);

        // 6. Tablodaki satir sayisinin 10 oldugunu test edin

        List<WebElement> satirSayisiList
                = driver.findElements(By.xpath("//div[@role='rowgroup']"));

        int expectedSatirSayisi = 10;
        int actualSatirSayisi = satirSayisiList.size();

        Assertions.assertEquals(actualSatirSayisi, expectedSatirSayisi);

        // 7. Tablodaki sutun sayisini yazdirin

        System.out.println("Sütun Sayısı: " + headersIsimleri.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolon = driver.findElements(By.xpath("//div[@role='rowgroup'][*]//div[@role='gridcell'][3]"));

        System.out.println(ReusableMethods.stringListeyeDonustur(ucuncuKolon));

        // 10. Method olusturun, Test sayfasindan satir ve sutun
        // sayisini girdigimde bana datayi yazdirsin

        System.out.println(getHucreData(2, 3));

        System.out.println(getHucreData(3, 2));


        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin


        for (int i = 1; i <= satirSayisiList.size(); i++) {

            String satirdakiFirstNameDegeri = getHucreData(i, 1);
            String satirdakiMaasMiktari = getHucreData(i, 5);

            if (satirdakiFirstNameDegeri.equalsIgnoreCase("Kierra")) {
                System.out.println(satirdakiMaasMiktari);
            }


        }
    }

    public String getHucreData(int satirNo, int sutunNo) {

        //div[@role='rowgroup'][    2     ]//div[@role='gridcell'][   3    ]

        String dinamikXpath = "//div[@role='rowgroup'][" + satirNo + "]//div[@role='gridcell'][" + sutunNo + "]";

        WebElement hedefHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return hedefHucreElementi.getText();

    }

}


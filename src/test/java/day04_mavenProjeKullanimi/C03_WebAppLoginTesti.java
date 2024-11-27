package day04_mavenProjeKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_WebAppLoginTesti {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. http://zero.webappsecurity.com
        //    sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button"))
                .click();

        //3. Login alanina  “username” yazdirin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

        //4. Password alanina “password” yazdirin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit"))
                .click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden
        driver.findElement(By.id("onlineBankingMenu"))
                .click();

        // Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link"))
                .click();


        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amaountKutusu = driver.findElement(By.id("sp_amount"));
        amaountKutusu.sendKeys("100");

        //9. tarih kismina “2023-09-10” yazdirin
        WebElement tarihKutusu = driver.findElement(By.id("sp_date"));
        tarihKutusu.sendKeys("2023-09-10");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees"))
                .click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement alertMesajElementi = driver.findElement(By.id("alert_content"));

        String expectedMesaj = "The payment was successfully submitted.";
        String actualMesaj = alertMesajElementi.getText();

        if (actualMesaj.equals(expectedMesaj)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");


        driver.quit();

    }
}
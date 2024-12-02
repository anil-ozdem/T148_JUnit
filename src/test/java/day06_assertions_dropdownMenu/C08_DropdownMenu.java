package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_DropdownMenu extends TestBaseEach {

    @Test
    public void test01(){

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();
        // 3. Login kutusuna “username” yazin
        WebElement loginBox = driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        // 5. Sign in tusuna basin,
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //    back tusuna basarak sayfaya donun
        driver.navigate().back();

        // 6. Online banking menusunden
        driver.findElement(By.xpath("//strong[.='Online Banking']"))
                .click();
        // Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link"))
                .click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency"))
                .click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.id("pc_currency"));
        Select select = new Select(ddm);

        select.selectByValue("EUR");

        // 9. “amount” kutusuna bir sayi girin
        WebElement amountBox = driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("3");

        // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollarsButton = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usDollarsButton.isSelected());

        // 11. “Selected currency” butonunu secin
        WebElement selectedCurrencyButton = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrencyButton.click();

        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"))
                .click();
        driver.findElement(By.id("purchase_cash"))
                .click();
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expectedFinallyTest = "Foreign currency cash was successfully purchased.";
        WebElement actualyFinallyTest = driver.findElement(By.id("alert_content"));

        Assertions.assertTrue(actualyFinallyTest.getText().contains(expectedFinallyTest));

        ReusableMethods.bekle(5);
    }
}
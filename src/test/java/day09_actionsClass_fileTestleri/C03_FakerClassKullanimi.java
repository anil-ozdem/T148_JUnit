package day09_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClassKullanimi {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); // Astrid
        System.out.println(faker.name().nameWithMiddle()); // Dr. Gema Weber Price
        System.out.println(faker.name().username()); // evelyne.ryan

        System.out.println(faker.address().zipCode()); // 79980-3430
        System.out.println(faker.address().fullAddress()); // 1578 Macejkovic Meadows, West Inellview, UT 78466-7155
        System.out.println(faker.address().cityName()); // Oscarstad

        System.out.println(faker.internet().emailAddress()); //melodie.witting@yahoo.com
        System.out.println(faker.internet().password()); // 9en9c6yxh79
        System.out.println(faker.internet().url()); // www.shiela-howe.name

        System.out.println(faker.harryPotter().character()); // Cadmus Peverell

        System.out.println(faker.gameOfThrones().character()); // Tya Lannister

        System.out.println(faker.lordOfTheRings().character()); // Peregrin Took
    }
}

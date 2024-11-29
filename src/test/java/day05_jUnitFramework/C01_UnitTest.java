package day05_jUnitFramework;

import java.util.*;

public class C01_UnitTest {

    public static void main(String[] args) {

        // verilen bir tamssayiyi kontrol edip
        // 3 basamakli pozitif bir tamsayi degilse "false"
        // 3 basamakli bir sayi ise "true" donduren bir method olusturun

        sayiKontrolMethodunuTestMethodu();

    }


    public static boolean sayiKontrol(int sayi) {

        if (sayi >= 100 && sayi <= 999) {
            return true;
        } else return false;
    }


    // sayiKontrol()'unun dogru calisip calismadigini kontrol eden
    // bir test method'u olusturun


    public static void sayiKontrolMethodunuTestMethodu() {

        Random random = new Random();
        boolean testSonucu = true;

        // true dondurmesi gereken 10 degeri test etsin

        for (int i = 1; i <=10 ; i++) {

            int randomSayi = 100 + random.nextInt(899);
            if (sayiKontrol(randomSayi) == false){      // urettgimiz sayilar 100-999 arasinda ve
                                                        // sayi kontrol method'u true dondurmeliydi
                                                        // demek ki sayi kontrol methodu dogru calismiyor

                testSonucu = false;

            }
        }

        if (testSonucu==true){
            System.out.println("10 farkli sayi uretildi ve method kontrol testi PASSED");
        } else System.out.println("sayi kontrol method'u dogru calismiyor, Test FAILED");

    }

}
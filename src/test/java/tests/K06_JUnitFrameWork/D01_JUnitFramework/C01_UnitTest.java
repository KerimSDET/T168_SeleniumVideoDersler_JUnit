package tests.K06_JUnitFrameWork.D01_JUnitFramework;

import java.util.Random;

public class C01_UnitTest {
    public static void main(String[] args) {

        //verilen bri sayi 3 basamakli pozitif bir sayi ise true
        //                 3 basamakli pozitif bir sayi degilse false
        //                 donduren bir method olusturun.


//        System.out.println(ucBasamakliPozitifSayiKontrolEt(100));
//        System.out.println(ucBasamakliPozitifSayiKontrolEt(765));
//        System.out.println(ucBasamakliPozitifSayiKontrolEt(999));
//        System.out.println(ucBasamakliPozitifSayiKontrolEt(99));
//        System.out.println(ucBasamakliPozitifSayiKontrolEt(1000));
//        System.out.println(ucBasamakliPozitifSayiKontrolEt(-455));

        uygunDegerTesti();
        uygunOlmayanDegerTesti1();
        uygunOlmayanDegerTesti2();
        uygunOlmayanDegerTesti3();

    }

    public static boolean ucBasamakliPozitifSayiKontrolEt (int sayi) {
        if (sayi >= 100 && sayi <= 999) {
            return true;
        } else return false;
    }

    //verilen sayi pozitif 3 basamakli sayi ise expectedSonuc = true

    public static void uygunDegerTesti () {
        Random random  = new Random();
        int sayi = random.nextInt(899)+100;
        boolean expectedcontrol = true;
        boolean actualcontrol = ucBasamakliPozitifSayiKontrolEt((sayi));

        if (expectedcontrol == actualcontrol) {
            System.out.println(sayi+" Uygun deger testi PASSED");
        } else System.out.println(sayi+" Uygun deger testi FAILED");

    }

    //verilan sayi pozitif 100'den kucuk bir sayi ise expectedSonuc =false
    public static void uygunOlmayanDegerTesti1 () {
        Random random  = new Random();
        int sayi = random.nextInt(98)+1;
        boolean expectedcontrol = false;
        boolean actualcontrol = ucBasamakliPozitifSayiKontrolEt(sayi);

        if (expectedcontrol == actualcontrol) {
            System.out.println(sayi+" Uygun olmayan deger testi-1 PASSED");
        } else System.out.println(sayi+" Uygun olmayan deger testi-1 FAILED");

    }

    //verilan sayi pozitif 999'dan buyuk bir sayi ise expectedSonuc =false

    public static void uygunOlmayanDegerTesti2 () {
        Random random  = new Random();
        int sayi = random.nextInt(99999999)+1000;
        boolean expectedcontrol = false;
        boolean actualcontrol = ucBasamakliPozitifSayiKontrolEt((sayi));

        if (expectedcontrol == actualcontrol) {
            System.out.println(sayi+" Uygun olmayan deger testi-2 PASSED");
        } else System.out.println(sayi+" Uygun olmayan deger testi-2 FAILED");
    }

    //verilan sayi negatif bir sayi ise expectedSonuc =false

    public static void uygunOlmayanDegerTesti3 () {
        Random random  = new Random();
        int sayi = -1* random.nextInt(99999999);
        boolean expectedcontrol = false;
        boolean actualcontrol = ucBasamakliPozitifSayiKontrolEt((sayi));

        if (expectedcontrol == actualcontrol) {
            System.out.println(sayi+" Uygun olmayan deger testi-3 PASSED");
        } else System.out.println(sayi+" Uygun olmayan deger testi-3 FAILED");
    }


}

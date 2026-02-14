package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C01_FakerClassKullanimi extends TestBase_Each {

    @Test
    public void test01() {

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());       //Vernia
        System.out.println(faker.name().lastName());        //Fritsch
        System.out.println(faker.name().name());            //erald Ferry
        System.out.println(faker.name().fullName());        // Miss Jenine Smitham
        System.out.println(faker.name().nameWithMiddle());  //Tova Baumbach Swaniawski
        System.out.println(faker.name().username());        //chelsie.kautzer


        System.out.println("============================================");
        System.out.println(faker.address().cityName()); // Lake Leahstad
        System.out.println(faker.address().streetAddress()); //6616 Lynwood Harbor
        System.out.println(faker.address().zipCode()); //82878
        System.out.println(faker.address().country()); //Sierra Leone
        System.out.println(faker.address().city()); //Rebekahfurt
        System.out.println(faker.address().streetAddress()); //294 Marissa Mills
        System.out.println(faker.address().fullAddress()); //127 Quigley Station, East Ellanmouth, WA 43505-6639
        System.out.println(faker.avatar().image()); //https://s3.amazonaws.com/uifaces/faces/twitter/shadeed9/128.jpg


        System.out.println("=============================");
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().domainName());
        System.out.println(faker.internet().password());
        System.out.println(faker.internet().url());

        /*
        Marilee
Olson
Carolann Swift IV
Wiley Rodriguez
Le Windler Hyatt
peggy.runolfsson
============================================
Botsfordmouth
6414 Darryl Village
45594-2592
Mauritius
Kautzermouth
588 Harris Route
84332 Desirae Gardens, Jannafurt, NJ 15969-7812
https://s3.amazonaws.com/uifaces/faces/twitter/ashernatali/128.jpg
=============================
herb.williamson@gmail.com
ohara.io
ow7fgeimr
www.manual-beatty.org
         */


    }


}

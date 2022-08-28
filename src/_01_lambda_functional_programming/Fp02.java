package _01_lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {

      /*
    1)  t-> "Logic" , (t, u)-> "Logic"
        Bu yapıya "Lambda Expession"
    2) Functional Programming kapsamında "Lambda Expession" kullanılabilir ama önerilmez.
       "Lambda Expession" yerine "Method Reference" tercih edilir.
    3) "Method Reference" kullanımı "Class Name :: Method Name"

       Aynı zamanda kendi class'larınızı da kullanabilirsiniz.
       Örneğin bir Animal class'ınız var ve bu class "eat()" methoduna sahip ==> "Animal :: eat"
 */

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);

        System.out.println(liste);//List = [8, 9, 131, 10, 9, 10, 2, 8]

        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        ciftElemanlariniYazdirFunctional(liste);
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();

        tekrarsizCiftElemanlarinKareleriToplami01(liste);
        tekrarsizCiftElemanlarinKareleriToplami02(liste);
        tekrarsizCiftElemanlarinKareleriToplami03(liste);
        tekrarsizCiftElemanlarinKuplerininCarpimi(liste);
        getMaxEleman(liste);

        //Odev
        enKucukEleman(liste);

        yedidenBuyukCiftMin(liste);
        tersSiralamaylaTekrarsizElemanlarinYarisi(liste);

    }

    //1) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Functional ve method reference)

    public static void listElemanlariniYazdirFunctional(List<Integer> list){

        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);

        /*
        Burada yapmıs oldugumuz islem :
        forEach(Utils::ayniSatirdaBosluklaYazdir) diyerek

        public class Utils {

        public static void ayniSatirdaBosluklaYazdir(Object obj){

        System.out.print(obj+" ");
         Classında olan  System.out.print(obj+" "); islemini :: ile daha kolay calıstırdık

        *** Bu işlemin bir defa yapılması yeterlidir!!!
         */

    }

    //2)Ardışık çift list elementlerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)

    public static void ciftElemanlariniYazdirFunctional(List<Integer> list){

        list.stream().filter(Utils::ciftElemaniSec).forEach(Utils::ayniSatirdaBosluklaYazdir);

        //.stream() bir akışa hazır ol demek gibi
    }

    //3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında
    // boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekElemanlarinKareleriniYazdir(List<Integer> list){

        list.stream().filter(Utils::tekElemaniSec).map(Utils::karesiniAl).forEach(Utils::ayniSatirdaBosluklaYazdir);

    }

    //4) Ardışık tek list elemanlarının küplerini tekrarsız olarak
    //aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list){

        list.stream().distinct().filter(Utils::tekElemaniSec).map(Utils::kupunuAl).forEach(Utils::ayniSatirdaBosluklaYazdir);

        //map elemana yeni bir deger atama anlamında kullanılıyor
    }

    //5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan
    // bir method oluşturun.

    //1. YOL:
    public static void tekrarsizCiftElemanlarinKareleriToplami01(List<Integer> list){

        Integer toplam = list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(0,Math::addExact);

        //Math::addExact toplama yapar

        System.out.println("1. YOL TOPLAM "+toplam);

    }

    //2. YOL:
    public static void tekrarsizCiftElemanlarinKareleriToplami02(List<Integer> list){

        Integer toplam = list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(Math::addExact).get();

        //Math::addExact toplama yapar

        System.out.println("2. YOL TOPLAM "+toplam);

    }

    //3. YOL:
    public static void tekrarsizCiftElemanlarinKareleriToplami03(List<Integer> list){

        Integer toplam = list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(0,Integer::sum);

        //Math::addExact toplama yapar

        System.out.println("3. YOL TOPLAM "+toplam);

    }

    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan
    // bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list){

        Integer carpim=list.stream().distinct().filter(Utils ::ciftElemaniSec).map(Utils::kupunuAl).reduce(1,(Math::multiplyExact));

        System.out.println("Carpim :" + carpim);

    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.

    public static void getMaxEleman(List<Integer> list){

        Integer max = list.stream().distinct().reduce(Math::max).get();
        System.out.println("Max = " + max);

    }

    //Ödev
    //8)List elemanları arasından en küçük değeri bulan bir
    // method oluşturun.(Method Reference)


    public static void enKucukEleman(List<Integer>list){

        Integer min = list.stream().distinct().reduce(Math::min).get();

        System.out.println("min = " + min); //min = 2
    }



    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri
    // bulan bir method oluşturun.

    public static void yedidenBuyukCiftMin(List<Integer> list){

        Integer min = list.stream().distinct().filter(t->t>7).filter(Utils::ciftElemaniSec).reduce(Math::min).get();

        System.out.println("Min : " + min);
    }

    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı
    // değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

    public static void tersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list){

        List<Double> sonuc = list.
                stream(). //Gerekli methodları kullanmamızı saglar
                        distinct().//Tekrarlı olanları almaz
                        filter(t->t>5).//kosula gore filtreleme yapar
                        map(Utils::yarisiniAl).//herbir elemanın degerini degistirmeye yarar
                        sorted(Comparator.reverseOrder()).//Sıralama yapar
                        collect(Collectors.toList());//Elamanları collection'a çevirir.

        System.out.println("Sonuc : " + sonuc);
    }


}

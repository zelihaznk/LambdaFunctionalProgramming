package _01_lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {

    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);

        buyukHarfleYazdir(liste);
        System.out.println();

        //buyukHarfleYazdir02(liste);

        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugaGoreTersYazdir(liste);
        System.out.println();
        sonKaraktereGoreTekrarsizYazdir(liste);
        System.out.println();
        uzunlukVeIlkHarfeGoreSiralaYazdir(liste);
        System.out.println();

        //bestenBuyukleriSil(liste);

        //baslangiciAYadaSonuNOlaniSil01(liste);
        //baslangiciAYadaSonuNOlaniSil02(liste);

        //uzunlugu8Ile10ArasiVeOIleBiteniSil(liste);

        System.out.println("uzunlugu12denAzMi : "+uzunlugu12denAzMi(liste));

        System.out.println("hicbiriXIleBaslamiyorMu : " + hicbiriXIleBaslamiyorMu(liste));

        System.out.println("rIleBitenVarMi : " + rIleBitenVarMi(liste));


    }

    //1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.

    //1. YOL:
    public static void buyukHarfleYazdir(List<String> list){
        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdaBosluklaYazdir);
        //Utils::ayniSatirdaBosluklaYazdir -->burası direkt yazdirma verir sout yazmaya gerek kalmaz

    }

     /*
        2. YOL:
    public static void buyukHarfleYazdir02(List<String> list){
        list.replaceAll(String::toUpperCase);
        System.out.println(list);
        //replaceAll(String::toUpperCase) tum elemanları ters cevirip
        // buyuk harfle yazdır demektir
    }
    */

    //2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugaGoreYazdir(List<String> list){

        //Kucukten buyuge:

        list.stream().
                sorted(Comparator.comparing(String::length)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //sorted(Comparator.comparing(String::length)) uzunluguna gore bu sekilde sıralama yapılır
        //Comparator.comparing() sıralama kosulunu belirtmek için kullanılır

    }

    //3) Elemanları uzunluklarına göre ters sıralayıp yazdıran
    // bir method oluşturun.

    public static void uzunlugaGoreTersYazdir(List<String> list){

        //Buyukten kucuge:

        list.stream().
                sorted(Comparator.comparing(String::length).reversed()).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
        //sorted(Comparator.comparing(String::length).reversed()) -->
        // Uzunluguna gore yazdır ama ters olsun demek
        //reversed() ters sırala demektir

    }

    //4) Elemanları son karakterlerine göre sıralayıp
    // tekrarsız yazdıran bir method oluşturun.

    public static void sonKaraktereGoreTekrarsizYazdir(List<String> list){

        list.
                stream().
                distinct().
                sorted(Comparator.comparing(Utils::sonKarakteriAl)).//tek tek alıp son karaktere göre sıralanıyor (Son harf aynı olunca listedeki eklenme sırasına uyuyor)
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //burada son karaktere(harfe) göre tekrarsız yazdırdık

    }

    //5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine
    // göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlukVeIlkHarfeGoreSiralaYazdir(List<String> list){

        list.stream().
                sorted(Comparator.comparing(String::length).thenComparing(Utils::ilkKarakteriAl)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //sorted(Comparator.comparing(String::length)) -->ilk önce uzunluklara göre sıraladık
        //.thenComparing(Utils::ilkKarakteriAl) ile alfabetik olarak sıralamayı saglarız
        //thenComparing daha sonra sırala demek
        //thenComparing() :==>siralama icin bir kosul daha belirtir
    }



    /*
    //6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.

    ---> Hepten sildiği için yorum satırına aldık

    public static void bestenBuyukleriSil(List<String> list){

        list.removeIf(t->t.length()>5); ===> list mutable oldugu için elemanları işlem sonrası kalıcı değiştiği için comment-out yapıyoruz

        System.out.println(list);

                //removeIf() -->eger boyleyse sil demek (Koşul doğruysa onu sil)

    }

     */

    //7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.

    /*
    //1. YOL:
    public static void baslangiciAYadaSonuNOlaniSil01(List<String> list){

        list.removeIf(t->t.charAt(0)== 'A' || t.charAt(0)== 'a' || t.charAt(t.length()-1)== 'N' || t.charAt(t.length()-1)== 'n');
        System.out.println(list);
    }



    //2. YOL:

    public static void baslangiciAYadaSonuNOlaniSil02(List<String> list){

        list.removeIf(t->t.startsWith("A")||t.startsWith("a")||t.endsWith("N")||t.endsWith("n"));
        System.out.println(list);

    }
     */

    /*
    //8) Uzunluğu 8 ile 10 arası olan yada 'o'
    // ile biten elemanları silen bir method oluşturun.

    public static void uzunlugu8Ile10ArasiVeOIleBiteniSil(List<String> list){

        list.removeIf(t->(t.length()>7 && t.length()<11) || t.endsWith("o"));
        System.out.println(list);

    }

     */

    //9) Tüm elemanların uzunluklarının 12'den az olup olmadığını
    // kontrol eden bir method oluşturun.

    public static boolean uzunlugu12denAzMi(List<String> list){

        return list.stream().allMatch(t->t.length()<12);

        //anyMatch() karşılastırma yapar (anyMatch=herhangi biri demektir)
        //allMatch() hepsini denetler
    }

    //10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.

    public static boolean hicbiriXIleBaslamiyorMu(List<String> list){

        return list.stream().noneMatch(t->t.startsWith("X") || t.startsWith("x"));

        //noneMatch() hiçbiri demektir

    }

    //11) Herhangi bir elemanın 'r' ile bitip
    // bitmediğini kontrol eden bir method oluşturun.

    public static boolean rIleBitenVarMi(List<String> list){

        return list.stream().anyMatch(t->t.endsWith("R") || t.endsWith("r"));

    }

}

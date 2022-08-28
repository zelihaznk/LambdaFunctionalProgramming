package _01_lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {

    /*
    1) Lambda (Functional Programming) Java 8 ile kullanilmaya baslanmistir.
    2) Functional Programming'de "Ne yapilacak" (What to do) uzerine yogunlasilir.
       Structor Programming "Nasil yapilacak" üzerine yogunlasir. (How to do) uzerine yogunlasir.
    3) Functional Programming Arrays ve Collections ile kullanilir.
    4) "entrySet() methodu ile Map, Set'e donusturulerek Functional Programming'de kullanilabilir.

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

        listElemanlariniYazdirStructured(liste);
        System.out.println();
        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        listCiftElemanlariniYazdirStructured(liste);
        System.out.println();
        System.out.println("Functional");
        ciftElemanlariniYazdirFunctional(liste);
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami01(liste);
        tekrarsizCiftElemanlarinKareToplami02(liste);

        terkrarsizCiftElemanlarinKupununCarpimi(liste);
        getMaxEleman1(liste);
        getMaxEleman2(liste);

        //ODEV:
        getMinValue(liste);
        System.out.println();
        getMinValue2(liste);

        getYedidenBuyukCiftMin(liste);
        getYedidenBuyukCiftMin2(liste);
        getYedidenBuyukCiftMin3(liste);
        getTersSiralamaylaTekrarsizElemanlarinYarisi(liste);




    }
    //1) Ardışık list elementlerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Structured)

    public static void listElemanlariniYazdirStructured(List<Integer> list){

        for (Integer w:list){

            System.out.print(w+" ");

        }

    }


    //1)Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list){

        list.stream().forEach(t-> System.out.print(t+" "));
        //stream() methodu collection dan elementleri akısa dahil etmek icin
        //ve methodlara ulasmak icin kullanilir.

    }

    //2)Cift sayi olan list elemanlarini aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Structured)

    public static void listCiftElemanlariniYazdirStructured(List<Integer> list){

        for (Integer w :list) {
            if (w%2==0){
                System.out.print(w+" ");
            }
        }

    }

    //2)Ardışık çift list elementlerini aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Functional)

    public static void ciftElemanlariniYazdirFunctional(List<Integer> list){

        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));

    }

    //3) Ardışık tek list elementlerinin karelerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekElemanlarinKareleriniYazdir(List<Integer> list){

        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));
        //elemanlarin degerleri degisecekse map() methodu kullanilacak

    }

    //4) Ardışık tek list elementlerinin küplerini tekrarsız olarak aynı
    // satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list){

        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
        //distinct() tekrarlilari aldirmamak için kullanilir
        //tekrarlari eler

    }

    //5) Tekrarsız çift elementlerin karelerinin toplamını
    // hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami01(List<Integer> list){

        Integer toplam = list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        //reduce() toplam yapabilmek icin iki degişken kullanacagımız için bunu yaptık
        //reduce listedeki cok olan elemanlari teke indirir
        //yani elemanlari alir toplar carpar cikariri boler ne yaparsa yapar tek satira indirger

        System.out.println(toplam);

    }

    public static void tekrarsizCiftElemanlarinKareToplami02(List<Integer> list){

        Integer toplam = list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce((t,u)->t+u).get();
        //reduce() toplam yapabilmek icin iki degişken kullanacagımız için bunu yaptık
        //reduce listedeki cok olan elemanlari teke indirir
        //yani elemanlari alir toplar carpar cikariri boler ne yaparsa yapar tek satira indirger

        System.out.println("Toplam :"+toplam);

    }

    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan
    // bir method oluşturun.

    public static void terkrarsizCiftElemanlarinKupununCarpimi(List<Integer> list){

        Integer carpim = list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        //reduce() çok elemanı teke düsürme

        //önce sayılar arasından cift olanları filter(t->t%2==0) ile filtreledik
        //daha sonra map(t->t*t*t) ile küpünü aldık
        //son olarak da reduce(1,(t,u)->t*u) ile tek tek degerleri reduce ile alıp çarpım yaptık

        System.out.println(carpim);
    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    //1. Yol

    public static void getMaxEleman1(List<Integer> list){

        Integer max = list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)-> t>u ? t:u);
        System.out.println(max);

        //Integer.MIN_VALUE en minimum değerden basla ve kıyasla demek icin boyle yaptik
        //tekrarsiz olanlari ayirmak icin distinct() kullandık(daha hızlı çalışssın diye. Yazmazaskta olur)

    }

    public static void getMaxEleman2(List<Integer> list){

        Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println("max = " + max);
        //stream().distinct() ile direkt sıralama yapılır

    }

    /*
    //Ödev
     8)List elemanları arasından en küçük değeri bulan
     bir method oluşturun.(2 Yol ile)
     */

    //1. Yol
    public  static void getMinValue( List<Integer> liste) {
        Integer min =liste.stream().distinct().reduce(liste.get(0),(t, u) -> t<u ? t : u);
        System.out.print("Odev min 1.yol :" + min);
    }

    //2. Yol

    // 2. yol
    public static void getMinValue2(List<Integer> list) {
        Integer min=list.stream().sorted().reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);
        System.out.println("Odev min 2.yol :"+ min);
    }



    //9) List elemanları arasından 7'den büyük, çift,
    // en küçük değeri bulan bir method oluşturun.

    //1. Yol
    public static void getYedidenBuyukCiftMin(List<Integer> list){

        Integer min = list.stream().
                distinct().
                filter(t->t%2==0).
                filter(t->t>7).
                reduce(Integer.MAX_VALUE,(t,u)->t<u ? t : u);
        System.out.println("1. Yol Min : " + min);
    }

    //2. Yol

    public static void getYedidenBuyukCiftMin2(List<Integer> list){

        Integer min = list.stream().
                distinct().
                filter(t->t%2==0).
                filter(t->t>7).
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.println("2. Yol Min : " + min);

        //Comparator.reverseOrder() tersten sıralama ( burada buyukten kucuge) sıralama
        //Comparator class ın içinde ismiyle çağrıldığı için statictir

    }

    //3. Yol

    public static void getYedidenBuyukCiftMin3(List<Integer> list){

        Integer min = list.stream().
                filter(t->t%2==0).
                filter(t->t>7).
                sorted().
                findFirst().
                get();
        System.out.println("3. Yol Min : " + min);
    }

    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların
    // yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan
    // bir method oluşturun.

    public static void getTersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list){

        List<Double> sonuc = list.stream().distinct().filter(t-> t>5).map(t-> t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        //degerler üzerinde degiştirme varsa map kullanılır
        //sorted(Comparator.reverseOrder()) ters sıralandıgı icin en buyugu başa gelir
        // map(t-> t/2.0) double olması için böyle yapıldı
        //collect() topla demektir
        //collect(Collectors.toList()) hepsini topla ama list icerisinde topla demektir

        System.out.println("sonuc = " + sonuc);

    }

}

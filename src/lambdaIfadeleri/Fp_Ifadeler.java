package lambdaIfadeleri;

import java.util.Arrays;
import java.util.List;

public class Fp_Ifadeler {

    //Lambda İfadeleri nedir?

    /*
    Bir diğer adı Closures olan Lambda ifadeleri kısaca kendi başlarına
    tanımlanabilen fonksiyonlardır. Neden kendi başına dedim çünkü bir
    sınıfa bağımlı olmalarına gerek kalmadan tanımlayabiliyoruz.
    Birçok fonksiyonel programlama dilinde mevcut olan lambda,
    Java 8 ile hayatımıza girmiş bulunmaktadır. Basit bir lambda
    ifadesi aşağıdaki gibidir.

         Method Parametresi    Lambda Operatoru    Method Govdesi
            \                       /                      /
             \                     /                      /
 Tech tech = (name)               ->        (System.out.println("Hello"+name));

     */

    //Neden Lambda kullanmalıyız?

    /*
    * Lambda’lar öncelikle kod miktarını azaltmak, daha sade, açık ve az kod
    yazmamızı sağlarlar.
    * Bir interface yazdığımızda bunu kullanabilmek için ya bir sınıf’a
    implement ediyorduk ya da interface’i onanim şekilde kullanıyorduk,
    artık lambda bize tek satırda nasıl bir implementasyon yapacağımızı ve
    sade bir şekilde kullanacağımızı gösterecek.
    * Lambda ifadelerinin sonucu bir değişkene atanabilir veya bir
    fonksiyona parametre olacak geçebilirsiniz.
     */

    //Lambda ile Functional İnterface

    /*
    Functional interface’ler, daha önce yazdığımız interface’lerden biraz
    farklı olarak şu şekilde tanımlanıyor. Bir tane soyut metod
    tanımlanabilirler ek olarak default metod dediğimiz gövdeli
    metodlarda sınır yoktur. Lambdalar kullanılırken JVM(Java Sanal Makinesi)
    arka tarafta lambdaları birer interface implementasyonuna çevirerek biz
    geliştiricilere büyük kolaylıklar sağlıyor.
     */

    //Örnek 1

    /*
    Tech adında bir interface olduğunu düşünelim ve bunun üzerinden bir
    implementasyon gerçekleştirelim.
     */


    public interface Tech {
        void name(String name);
    }

    public class Main {
        public static void main(String[] args) {
            Tech tech = new Tech() {
                @Override
                public void name(String name) {
                    System.out.print("Hello " + name);
                }
            };
        }
    }

    /*
    Yukarıdaki kod parçalarında basit bir interface oluşturduk ve ondan
    bir nesne oluşturarak anonim inner class şeklinde kullanmış olduk.
    Aslında hoş olmayan kod karmaşı da beraberinde gelmiş oldu.
    Lambda ile yapalim simdi;
     */

    //Lambda ile Kullanım

    @FunctionalInterface
    public interface Tech2 {
        void name(String name);
    }

    public class Main2 {
        public static void main(String[] args) {
            Tech tech = name -> System.out.print("Hello " + name);
        }
    }

    /*
    Fark, gözle görünür bir şekilde sadece ve kolay kullanım olarak göze çarpıyor.
    Functional Interface’ler sadece bir tane soyut metod barındırabilirler. Birden fazla olamaz.
     */

    //Örnek 2

    public interface Calculate {
        double execute(double first, double second);
    }

    public static void main(String[] args) {
        double result = execute(3, 8, new Calculate() {
            @Override
            public double execute(double first, double second) {
                return first + second;
            }
        });
    }

    private static double execute(double first, double second, Calculate calculate){
        return calculate.execute(first, second);
    }

    //Lambda ile Kullanım


    @FunctionalInterface
    public interface Calculate2 {
        double execute(double first, double second);
    }

    public class Main3 {
        public static void main(String[] args) {
            double result = execute(5.0, 7.0, (a, b) -> (a + b));
        }

        private static double execute(double first, double second, Calculate calculate){
            return calculate.execute(first, second);
        }
    }

    //Tek satırda lambda’yı parametre geçerek istediğimiz eşitliği yazabiliyoruz.

    //Lambda ile Stream API

    //Filter

    /*
    Bir liste veya dizi içerisinde bazı şartlara göre elemanları ayırt
    etmek isteyebiliriz, mesela bir sipariş listesinde fiyatı en yüksek
    olan siparişi getir veya kullanıcı listesinde yaşı belirli bi yaşın
    üzerinde olanları getir diyebiliriz bu gibi filtreleme gerektiren
    durumlarda Java 8 Stream’ler ile gelen filter özelliği çok
    kullanışlı bir hal alıyor.

     */

    //Örnek 3

    /*
    Bir kullanıcı listeli oluşturalım ve kullanıcıların yaşlarına göre
    filtreleme yapalım.
     */

   /*

   public class Main {
    public static void main(String[] args) {

        User user1 = new User("John", 30);
        User user2= new User("Doe", 20);
        User user3 = new User("Mark", 22);

        List<User> userList = Arrays.asList(user1, user2, user3);

        for (User user : userList) {
            if (user.getAge() >21){
                System.out.print(user);
            }
        }
    }

}
    */

    //Lambda ile Filter Kullanımı

    /*

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John", 30);
        User user2= new User("Doe", 20);
        User user3 = new User("Mark", 22);

        List<User> userList = Arrays.asList(user1, user2, user3);

        userList.stream().filter(u -> u.getAge() > 21).forEach(System.out::print);
    }
}
     */















}

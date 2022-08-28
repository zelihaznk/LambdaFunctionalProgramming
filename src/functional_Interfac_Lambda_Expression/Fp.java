package functional_Interfac_Lambda_Expression;

public class Fp {

    /*
    Java’da Functional Interface ve Lambda Expression

    Functional interface, Java 8 ile gelmiş özelliklerden biridir.
    Function interface, içerisinde sadece bir tane abstract metodu olan
    interface’dir. Eğer ilgili interface’in türetildiği interface’de abstract
    metot varsa bu durumda da functional interface olur.
    Functional interface’ler, lambda expression’ların kullanılabilmesi için tanımlanırlar.
    Functional interface’ler tanımlanırken, @FunctionalInterface anotasyonu
    kullanması zorunlu değildir. Bu anotasyon sadece validasyon yapma amacıyla
    kullanılır. Eğer anotasyon eklenirse ve birden fazla abstract metot
    eklenmeye çalışılırsa, bu durumda compile error verecektir.


    Konuyu anlamak açısında Java’nın içinde mevcut olan functional interface’lerden birini inceleyelim;


     @FunctionalInterface
     public interface Runnable {

     public abstract void run();
      }

      -----> Yukarıda Runnable interface’i bir functional interface’dir.
      Bu tanım sayesinde Runnable, lambda ile kullanılabilir.



      public class TestBuiltIn {

    public static void main(String[] args) {

        // Before 1.8
        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {

                System.out.println("Before 1.8");
            }
        };
        runnable1.run();

        // 1.8
        Runnable runnable2 = () -> System.out.println("1.8");
        runnable2.run();

    }
}

       38 numaralı satırda Java 1.8 den önceki teknikle bir tanımlama yapılmıştır.
       Bu tanımlama biçimine anonymous denir. Ve 46. satırda run metodu
       çalıştırılır.

       49 numaralı satırda ise Java 1.8 ile gelen tanımlama biçimi mevcuttur.
       Bir alt satırda da metodu çalıştırılır.


       Functional interface oluşturalım ve daha sonra lambda ile kullanalım;

       @FunctionalInterface
       interface Matematics {

       void operation (int a, int b);
       }

       public class TestCustom {

       public static void main(String[] args) {

        Matematics sum = (a, b) -> System.out.println("Sum: " + (a + b));
        sum.operation(10, 6);

        Matematics minus = (int a, int b) -> System.out.println("Minus: " + (a - b));
        minus.operation(10, 6);

        Matematics multiply = (int a, int b) -> System.out.println("Multiply: " + (a * b));
        multiply.operation(10, 6);
    }
}

        Öncelikle 65. satırda functional interface’i tanımlıyoruz.
        75, 78 ve 81. satırlarda farklı işlemler için lambda tanımı yapıyoruz.
        76, 79 ve 82. satırlarda ise bu metotları kullanıyoruz.


        Eğer lambda tanımlama satırı birden fazla ise aşağıdaki gibi tanımlama yapılır.


        Matematics mutliLine = (a, b) -> {
        System.out.println(“First line…”);
        System.out.println(“Result is: “);
        System.out.println(a + b);
         };

        Eğer birden fazla satır olacaksa süslü parantezler arasına alınır.

        Not: Süslü parantezler arasında istediğimiz işlemleri yapabiliriz.

     */









}

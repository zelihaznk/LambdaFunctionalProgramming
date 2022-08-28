package lambda_functional_programming;

public class Utils {


    public static void ayniSatirdaBosluklaYazdir(Object obj){

        System.out.print(obj+" ");
    }

    public static boolean ciftElemaniSec(Integer x){ //true veya false verecegi icin boolean oldu


        return x%2==0; //cift ise true tek ise false verir

    }

    boolean x =1<2; //mantıksal bir cevap oldugu için boolean cevap verir

    public static boolean tekElemaniSec(Integer x){ //true veya false verecegi icin boolean oldu


        return x%2!=0; //cift ise true tek ise false verir

    }

    public static int karesiniAl(int x){

        return x*x;
    }

    public static int kupunuAl(int x){

        return x*x*x;
    }

    public static double yarisiniAl(int x){
        return x/2.0;
    }

    public static char sonKarakteriAl(String str){
        return str.charAt(str.length()-1); //son karakterin indexini almak için bunu kullanırız
    }

    public static char ilkKarakteriAl(String str){
        return str.charAt(0);
    }

    public static int rakamlarToplaminiAl(int x){

        int toplam =0;

        while (x>0){

            toplam += x%10;
            x /= 10;

        }
        return toplam;
    }


}

package _03_lambdaIfadeleri;

public class Main {

    Tech tech = new Tech() {
        @Override
        public void name(String name) {
            System.out.print("Hello " + name);
        }
    };


    public static void main(String[] args) {
        Tech tech = name -> System.out.print("Hello " + name);
    }


    double result = execute(3, 8, new Calculate() {
        @Override
        public double execute(double first, double second) {
            return first + second;
        }
    });

    private static double execute(double first, double second, Calculate calculate){
        return calculate.execute(first, second);
    }


}

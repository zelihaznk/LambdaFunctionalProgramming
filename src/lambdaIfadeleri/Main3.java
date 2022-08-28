package lambdaIfadeleri;

public class Main3 {

    public static void main(String[] args) {
        double result = execute(5.0, 7.0, (a, b) -> (a + b));
    }

    private static double execute(double first, double second, Calculate calculate){
        return calculate.execute(first, second);
    }
}

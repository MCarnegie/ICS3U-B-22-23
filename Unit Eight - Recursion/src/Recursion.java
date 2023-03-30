public class Recursion {
    public static void main(String[] args) {
        //System.out.println(factorial(7));
        System.out.println(fibonacci(1000));
    }

    static long[] results = new long[1001];

    private static long fibonacci(int i) {
        if(results[i] != 0)
            return results[i];

        if(i == 1 || i == 2)
            return 1;
        
        results[i] = fibonacci(i-1) + fibonacci(i-2);

            return results[i];
    }

    private static int factorial(int i) {
        if(i == 1)
            return 1;
        
        return i * factorial(i-1);
    }
}

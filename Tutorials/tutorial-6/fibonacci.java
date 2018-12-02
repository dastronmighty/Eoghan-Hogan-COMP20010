/**
 * fibonacci
 */
public class fibonacci {

    /**
     * 
     * @param n
     * @return fib of n
     */
    public static int iterativeFib(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1;
        int lastf = 1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += lastf;
            lastf = temp;
        }
        return fib;
    }

    /**
     * 
     * @param n
     * @return fib of n
     */
    public static int recursiveFib(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    public static void main(String args[]) {

        System.out.println("Iterative fibonacci:");
        System.out.println(iterativeFib(5));
        System.out.println(iterativeFib(10));
        System.out.println(iterativeFib(15));
        System.out.println(iterativeFib(20));

        System.out.println("Recursive fibonacci:");
        System.out.println(recursiveFib(5));
        System.out.println(recursiveFib(10));
        System.out.println(recursiveFib(15));
        System.out.println(recursiveFib(20));
    }
}
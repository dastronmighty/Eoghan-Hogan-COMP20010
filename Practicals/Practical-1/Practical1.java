import java.util.Arrays;
import java.util.Random;

/**
 * Practical1
 */
public class Practical1 {

    /**
     * QUESTION 2
     * 
     * @param a an array
     * @return stringified array
     */
    public static String ArrayToString(int[] a) {
        if (a.length == 0) {
            return "[]"; // return this if the array is empty
        }
        String arr = "[";
        for (int i = 0; i < a.length - 1; i++) { // loop through each element
            arr += a[i] + ", ";
        }
        arr += a[a.length - 1] + "]";
        return arr; // return our constructed stringified array
    }

    /**
     * QUESTION 3
     * 
     * return true if two integer arrays have same length and all corresponding
     * pairs of integers are equal
     * 
     * @param a integer array
     * @param b integer array
     * @return true if a = b otherwise false
     */

    public static boolean eq(int[] a, int[] b) {
        if (a.length == b.length) { // are they equal in length
            boolean eq = true;
            for (int i = 0; i < b.length; i++) {
                if (a[i] != b[i]) { // do the elements match?
                    eq = false;
                    break;
                }
            }
            return eq;
        }
        return false;
    }

    /**
     * QUESTION 4:
     * 
     * copies array a
     * 
     * @param a
     * @return a copied version of a
     */
    public static int[] copyArray(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    /**
     * QUESTION 6
     * 
     * @param a 2 dimensional array
     * @return a stringified version of a
     */
    public static String twoDimArrtoString(int[][] a) {
        if (a.length == 0) { // if the array is empty
            return "[]";
        }
        String arrString = "[ \n"; // start of array
        for (int i = 0; i < a.length; i++) { // for each sub array
            if (a[i].length == 0) { // if the sub array is empty
                if (i == a.length - 1) {
                    arrString += "[]\n";
                } else {
                    arrString += "[],\n";
                }
            } else {
                arrString += "["; // start of sub array
                for (int j = 0; j < a[i].length - 1; j++) { // loop through each element
                    arrString += a[i][j] + ", "; // add each element
                }
                if (i == a.length - 1) {
                    arrString += a[i][a[i].length - 1] + "]\n";
                } else {
                    arrString += a[i][a[i].length - 1] + "],\n";
                }
            }
        }
        arrString += "]";
        return arrString;
    }

    public static void increment(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] += 1;
        }
    }

    public static void reverse(int[] a) {
        int temp;
        int split = (a.length / 2);
        for (int i = 0; i <= split - 1; i++) {
            temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - i - 1] = temp;
        }
    }

    public static void moveZeros(int[] a) {
        int timeOnIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                for (int j = i; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length - 1] = 0;
                i--;
                timeOnIndex++;
            }
            if (timeOnIndex >= a.length) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        /**
         * QUESTION 1: The following code prints out the location in memory of the array
         */
        int[] a1 = new int[5];
        System.out.println(a1);
        System.out.println("");

        /**
         * QUESTION 2: Test out code
         */
        int[] a2 = { 1, 2, 3 };
        System.out.println(ArrayToString(a2));
        System.out.println("");

        /**
         * QUESTION 3: test code
         */
        int[] a3 = { 3, 1, 4, 1, 5 };
        int[] b3 = { 3, 1, 4, 1 };
        int[] c3 = { 3, 1, 4, 1, 5 };
        int[] d3 = { 2, 7, 1, 8, 2 };
        System.out.println(eq(a3, a3));
        System.out.println(eq(a3, b3));
        System.out.println(eq(a3, c3));
        System.out.println(eq(a3, d3));
        System.out.println("");

        /**
         * QUESTION 4: test code
         */
        int[] a4 = { 56, 14, -46, 15, 36, 99, 77, 18, 29, 49 };
        int[] b4 = copyArray(a4);
        // check its not a clone
        a4[0] = -1;
        System.out.println(eq(a4, b4));
        System.out.println(ArrayToString(b4)); // print a string representation 􏰀of the array
        System.out.println("");

        /**
         * QUESTION 5
         */
        int[][] a5 = new int[3][5];

        /**
         * QUESTION 6
         */
        int[][] a6 = new int[5][5];
        System.out.println(twoDimArrtoString(a6));
        System.out.println("");

        /**
         * QUESTION 7
         */
        int N7 = 10;
        int[] a7 = new int[N7];
        Random random = new Random();
        for (int i = 0; i < N7; i++) {
            a7[i] = random.nextInt(100);
        }
        System.out.println("Original array : \t" + Arrays.toString(a7));
        increment(a7);
        System.out.println("Incremented array : \t" + Arrays.toString(a7));
        System.out.println("");

        /**
         * QUESTION 8
         */
        int N8 = 10;
        int[] a8 = new int[N8];
        for (int i = 0; i < N8; i++) {
            a8[i] = random.nextInt(100);
        }
        System.out.println("Original array : \t" + Arrays.toString(a8));
        reverse(a8);
        System.out.println("Reversed array : \t" + Arrays.toString(a8));
        System.out.println("");

        /**
         * QUESTION 9
         * 
         * 0, 0, 12, 0, 2, 0, 0, 0, 5, 0, 8
         * 
         */
        int[] a = { 0, 0, 1, 2, 3, 0, 4, 5, 6, 0, 0, 0, 7, 0, 0, 8, 0, 9 };
        System.out.println("Original array: \t" + Arrays.toString(a));
        moveZeros(a);
        System.out.println("After moving 0s: \t" + Arrays.toString(a));

    }
}
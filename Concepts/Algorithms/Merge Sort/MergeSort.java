import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

/**
 * InsertionSort
 */
public class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static <T extends Comparable<? super T>> void merge(T[] array, int l, int m, int r)
            throws ArrayStoreException {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        T[] L = T[n1];
        T[] R = T[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts array[l..r] using
    // merge()
    public static <T extends Comparable<? super T>> void mergeSort(T[] array, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 10; i <= 100000; i *= 10) {

            long average = 0;

            for (int k = 0; k < 10; k++) {

                Integer array[] = new Integer[i];

                for (int j = 0; j < i; j++) {
                    array[j] = random.nextInt((i - 1));
                }

                long startTime = System.nanoTime();

                mergeSort(array, 0, array.length - 1);

                final long finalTime = System.nanoTime() - startTime;

                average += finalTime;

            }
            average /= 10;
            double averageTime = (double) average / 1000000000;

            System.out.printf("elements:\t%d\t\tseconds to sort:\t%.9f\n", i, averageTime);

        }

    }
}
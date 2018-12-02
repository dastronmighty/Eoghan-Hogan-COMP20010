import java.text.DecimalFormat;
import java.util.*;

/**
 * InsertionSort
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void swap(T[] array, int x, int y) {
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            T key = array[i];
            while ((j >= 0) && (array[j].compareTo(key) > 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
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

                insertionSort(array);

                final long finalTime = System.nanoTime() - startTime;

                average += finalTime;

            }
            average /= 10;
            double averageTime = (double) average / 1000000000;

            System.out.printf("elements:\t%d\t\tseconds to sort:\t%.9f\n", i, averageTime);

        }

    }
}
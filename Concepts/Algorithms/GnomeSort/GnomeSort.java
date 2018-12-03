import java.util.*;

/**
 * GnomeSort
 */
public class GnomeSort {

    public static <T extends Comparable<T>> void swap(T[] array, int x, int y) {
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static <T extends Comparable<T>> void gnomeSort(T[] array) {
        int i = 1;
        int j = 2;
        while (i < array.length) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                i = j++;
            } else {
                swap(array, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 10; i <= 10000; i *= 10) {

            long average = 0;

            for (int k = 0; k < 10; k++) {

                Integer array[] = new Integer[i];

                for (int j = 0; j < i; j++) {
                    array[j] = random.nextInt((i - 1));
                }

                long startTime = System.nanoTime();

                gnomeSort(array);

                final long finalTime = System.nanoTime() - startTime;

                average += finalTime;

            }
            average /= 10;
            double averageTime = (double) average / 100000000;

            System.out.printf("elements:\t%d\t\tseconds to sort:\t%.9f\n", i, averageTime);

        }

    }
}
import java.util.Arrays;
import java.util.Random;

/**
 * BubbleSort
 * 
 * implementation of bubble sort. Note it only works on an array whose elements
 * extend the comparable class
 */
public class BubbleSort {

    public static <E> void swap(E[] array, int x, int y) {
        E temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static <T extends Comparable<T>> void Bubblesort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
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

                Bubblesort(array);

                final long finalTime = System.nanoTime() - startTime;

                average += finalTime;

            }
            average /= 10;
            double averageTime = (double) average / 100000000;

            System.out.printf("elements:\t%d\t\tseconds to sort:\t%.9f\n", i, averageTime);

        }

    }

}

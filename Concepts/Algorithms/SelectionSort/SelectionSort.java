/**
 * SelectionSort
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void swap(T[] array, int x, int y) {
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (array[j].compareTo(array[min_idx]) < 0) {
                    min_idx = j;
                }
            swap(array, i, min_idx);

        }
    }

    public static void main(String[] args) {

    }
}
public class MergeSort {

    public static <E extends Comparable<? super E>> void sort(Queue<E> queue) {
      if (queue == null) {
        return;
      }
      int size = queue.size();
      if (size <= 1) {
        return;
      }
  
      int m = size / 2;
      Queue left, right;
      left = new Queue();
      right = new Queue();
  
      for (int i = 0; i < m; i++) {
        left.enqueue(queue.dequeue());
      }
      for (int i = m; i < size; i++) {
        right.enqueue(queue.dequeue());
      }
  
      sort(left);
      sort(right);
      merge(left, right, queue);
    }
  
    private static <E extends Comparable<? super E>> void merge(Queue<E> left, Queue<E> right, Queue<E> result) {
      for (; left.size() > 0 && right.size() > 0;) {
        if (left.first().compareTo(right.first()) != 1) {
          result.enqueue(left.dequeue());
        } else {
          result.enqueue(right.dequeue());
        }
      }
      if (left.size() > 0) {
        for (; !left.isEmpty();) {
          result.enqueue(left.dequeue());
        }
      }
      if (right.size() > 0) {
        for (; !right.isEmpty();) {
          result.enqueue(right.dequeue());
        }
      }
    }
  }


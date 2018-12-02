/**
 * QueueTest
 */
public class QueueTest {

    public static <E> Queue<E> reverseQueue(Queue<E> q) {
        // Base case
        if (q.empty())
            return q;

        // Dequeue current item (from front)
        E data = q.dequeue();

        // Reverse remaining queue
        q = reverseQueue(q);

        // Enqueue current item (to rear)
        q.enqueue(data);

        return q;
    }

    public static void main(String[] args) {

        Queue<Integer> myQueue = new Queue<Integer>();

        int i = 0;
        System.out.println(myQueue.toString());
        myQueue.enqueue(i++);
        System.out.println(myQueue.toString());
        myQueue.enqueue(i++);
        System.out.println(myQueue.toString());
        myQueue.enqueue(i++);
        System.out.println(myQueue.toString());
        myQueue.enqueue(i++);
        System.out.println(myQueue.toString());
        System.out.printf("dequed: %s\n", myQueue.dequeue().toString());
        System.out.println(myQueue.toString());
        System.out.printf("dequed: %s\n", myQueue.dequeue().toString());
        System.out.println(myQueue.toString());
        myQueue.enqueue(i++);
        myQueue.enqueue(i++);
        myQueue.enqueue(i++);
        myQueue.enqueue(i++);
        System.out.println(myQueue.toString());
        System.out.printf("dequed: %s\n", myQueue.dequeue().toString());
        System.out.println(myQueue.toString());

        myQueue = reverseQueue(myQueue);
        System.out.printf("reversed queue:\n%s", myQueue.toString());
        System.out.printf("dequed: %s\n", myQueue.dequeue().toString());
        System.out.println(myQueue.toString());
        myQueue.enqueue(i++);
        System.out.println(myQueue.toString());

    }
}
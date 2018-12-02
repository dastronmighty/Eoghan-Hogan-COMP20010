/**
 * ArrayQueueTest
 */
public class ArrayQueueTest {

    public static void main(String[] args) {

        ArrayQueue<Integer> myAQueue = new ArrayQueue<Integer>(20);

        int i = 0;

        System.out.println(myAQueue.size());
        System.out.println(myAQueue.toString());
        myAQueue.enqueue(i++);
        System.out.println(myAQueue.toString());
        myAQueue.enqueue(i++);
        System.out.println(myAQueue.toString());
        myAQueue.enqueue(i++);
        System.out.println(myAQueue.toString());
        myAQueue.enqueue(i++);
        System.out.println(myAQueue.toString());
        System.out.printf("dequed: %s\n", myAQueue.dequeue().toString());
        System.out.println(myAQueue.toString());
        myAQueue.enqueue(i++);
        myAQueue.enqueue(i++);
        myAQueue.enqueue(i++);
        myAQueue.enqueue(i++);
        System.out.println(myAQueue.toString());
        System.out.printf("dequed: %s\n", myAQueue.dequeue().toString());
        System.out.println(myAQueue.toString());

    }
}
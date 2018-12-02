/**
 * DequeTest
 */
public class DequeTest {

    public static void main(String[] args) {

        Deque<Integer> myDeque = new Deque<Integer>();

        System.out.println("inserting at the front: ");
        myDeque.insertFront(1);
        System.out.println(myDeque.toString());
        myDeque.insertFront(2);
        System.out.println(myDeque.toString());
        myDeque.insertFront(3);
        System.out.println(myDeque.toString());

        System.out.printf("size of deque: %d\n", myDeque.size());

        System.out.println("\ninserting at the back: ");
        myDeque.insertBack(4);
        System.out.println(myDeque.toString());
        myDeque.insertBack(5);
        System.out.println(myDeque.toString());
        System.out.printf("size of deque: %d\n", myDeque.size());

        System.out.println("\nremoving from the front: ");
        myDeque.eraseFront();
        System.out.println(myDeque.toString());
        System.out.printf("size of deque: %d\n", myDeque.size());

        System.out.println("\nremoving from the back: ");
        myDeque.eraseBack();
        System.out.println(myDeque.toString());
        System.out.printf("size of deque: %d\n", myDeque.size());

    }
}
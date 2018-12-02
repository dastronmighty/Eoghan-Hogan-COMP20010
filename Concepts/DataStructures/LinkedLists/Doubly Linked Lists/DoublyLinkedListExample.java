
/**
 * DoublyLinkedListExample
 */
public class DoublyLinkedListExample {

    public static void main(String[] args) {
        try {
            DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
            System.out.println("running doubly linked lists");
            System.out.println(dll.toString());
            dll.addFirst("20");
            System.out.println(dll.toString());
            dll.addFirst("10");
            System.out.println(dll.toString());
            dll.addLast("-1");
            System.out.println(dll.toString());
            dll.removeFirst();
            System.out.println(dll.toString());
            dll.removeLast();
            System.out.println(dll.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
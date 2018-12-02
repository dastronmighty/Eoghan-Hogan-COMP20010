/**
 * PriorityQueueTest
 */
public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Student> stPriorityQueue = new PriorityQueue<Student>();

        Student student1 = new Student("A.H", 19, 4.2);
        Student student2 = new Student("M.B.J", 19, 3.2);
        Student student3 = new Student("E.H", 20, 2.9);
        Student student4 = new Student("S.M.G", 21, 4.0);
        Student student5 = new Student("L.P", 18, 3.5);

        stPriorityQueue.insert(student1);
        stPriorityQueue.insert(student2);
        stPriorityQueue.insert(student3);
        stPriorityQueue.insert(student4);
        stPriorityQueue.insert(student5);

        int size = stPriorityQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stPriorityQueue.removeMin().toString());
        }

    }

}
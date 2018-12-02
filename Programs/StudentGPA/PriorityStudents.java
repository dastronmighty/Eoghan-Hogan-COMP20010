import java.util.PriorityQueue;

/**
 * PriorityStudents
 */
public class PriorityStudents {

    public static void main(String[] args) {

        // Creating Priority queue
        PriorityQueue<Student> pq = new PriorityQueue<Student>();

        pq.add(new Student("Nataly Ware", 21, 4.0));
        pq.add(new Student("Mira Weiss", 19, 3.5));
        pq.add(new Student("Emilie Gibbs", 20, 3.2));
        pq.add(new Student("Lisa Boone", 22, 4.7));
        pq.add(new Student("Karsyn Terry", 20, 4.8));
        pq.add(new Student("Jeremy Schwartz", 18, 4.6));
        pq.add(new Student("Aleah Gaines", 19, 4.1));
        pq.add(new Student("Arianna Reeves", 20, 3.9));
        pq.add(new Student("Walker Holloway", 22, 3.8));
        pq.add(new Student("Adelyn Walter", 24, 4.95));
        pq.add(new Student("Damion Sanders", 25, 3.2));
        pq.add(new Student("Aimee Quinn", 21, 2.7));

        // Printing names of students in priority order 14
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().toString());
        }

    }
}
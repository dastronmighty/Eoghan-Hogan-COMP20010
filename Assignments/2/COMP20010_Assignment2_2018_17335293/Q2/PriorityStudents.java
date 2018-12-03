
/**
 * PriorityStudents
 */
public class PriorityStudents {

    public static void main(String[] args) {
        
        PriorityQueue<Student> stPriorityQueue = new PriorityQueue<Student>();
     
        Student student1 = new Student("Nataly Ware", 21, 4.0);
        Student student2 = new Student("Mira Weiss", 19, 3.5);
        Student student3 = new Student("Emilie Gibbs", 20, 3.2);
        Student student4 = new Student("Lisa Boone", 22, 4.7);
        Student student5 = new Student("Karsyn Terry", 20, 4.8);
        Student student6 = new Student("Jeremy Schwartz", 18, 4.6);
        Student student7 = new Student("Aleah Gaines", 19, 4.1);
        Student student8 = new Student("Arianna Reeves", 20, 3.9);
        Student student9 = new Student("Walker Holloway", 22, 3.8);
        Student student10 = new Student("Adelyn Walter", 24, 4.95);
        Student student11 = new Student("Damion Sanders", 25, 3.2);
        Student student12 = new Student("Aimee Quinn", 21, 2.7);

        stPriorityQueue.insert(student1);
        stPriorityQueue.insert(student2);
        stPriorityQueue.insert(student3);
        stPriorityQueue.insert(student4);
        stPriorityQueue.insert(student5);
        stPriorityQueue.insert(student6);
        stPriorityQueue.insert(student7);
        stPriorityQueue.insert(student8);
        stPriorityQueue.insert(student9);
        stPriorityQueue.insert(student10);
        stPriorityQueue.insert(student11);
        stPriorityQueue.insert(student12);

        while (!stPriorityQueue.isEmpty()){
            System.out.println(stPriorityQueue.removeMin().toString());
        }

    }

}

/**
 * Student
 */

import java.lang.Comparable;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private double GPA;

    /**
     * Student class Constructor
     * 
     * @param name the name to set
     * @param age  the age to set
     * @param GPA  the GPA to set
     */
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "name: " + name + "\tage: " + age + "\tGPA: " + GPA;
    }

    @Override
    public int compareTo(Student st) {
        if (GPA == st.GPA)
            return 0;
        else if (GPA > st.GPA)
            return 1;
        else
            return -1;

    }

}
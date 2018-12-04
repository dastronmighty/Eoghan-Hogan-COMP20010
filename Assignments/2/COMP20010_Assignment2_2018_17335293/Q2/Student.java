
/**
 * Student
 */

import java.lang.Comparable;

import java.lang.StringBuilder;

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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the gPA
     */
    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("\t:\tGPA-");
        sb.append(getGPA());
        sb.append(", Age-");
        sb.append(getAge());
        return sb.toString();
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
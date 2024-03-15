package week3;

public class Student implements Comparable<Student> {
    public double gpa;

    public Student(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        if (this.gpa < o.gpa) return -1;
        else if (this.gpa > o.gpa) return 1;
        else return 0;
    }
}

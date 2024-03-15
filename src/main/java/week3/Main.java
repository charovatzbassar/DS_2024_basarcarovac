package week3;

import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] elements = {1,2,10,4,5,6, 15, 11, 3};
////        System.out.println(Search.binarySearch(elements, 6));
//
//
//        Student[] students = { new Student(9.5), new Student(8.5), new Student(8.54), new Student(7.5), new Student(6.5) };
//
////        for (int element : elements) {
////            System.out.println(element);
////        }
//
//        Sort.bubbleSort(students);
//
//        for (Student student : students) {
//            System.out.println(student.gpa);
//        }
        IPSearch.search(FileUtils.readFile("IP2LOCATION.csv"), "192.168.0.1");
    }
}

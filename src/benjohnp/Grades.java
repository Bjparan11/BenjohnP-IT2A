package BenjohnP;
import java.util.Scanner;

public class Grades {
   
     private String id;
    private String name;
    private int math, sci, eng, com;

    public void getGrade() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        id = input.nextLine();
        System.out.print("Enter your full name: ");
        name = input.nextLine();
        System.out.print("Enter Marks in:\n");
        System.out.print("Math: ");
        math = input.nextInt();
        System.out.print("Science: ");
        sci = input.nextInt();
        System.out.print("English: ");
        eng = input.nextInt();
        System.out.print("Computer: ");
        com = input.nextInt();

        printGradeDetails();
    }

    public String getId() {
        return id;
    }

    public void printGradeDetails() {
        int totalMarks = math + sci + eng + com;
        double averageMarks = totalMarks / 4.0;

        System.out.println("-------------------");
        System.out.println("Grade Detail");
        System.out.println("-------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Total Average: " + averageMarks);
        System.out.println("-------------------");
    }

    public void editGrade() {
        Scanner input = new Scanner(System.in);

        System.out.println("Edit Marks for " + name);
        System.out.print("Enter new marks in Math: ");
        math = input.nextInt();
        System.out.print("Enter new marks in Science: ");
        sci = input.nextInt();
        System.out.print("Enter new marks in English: ");
        eng = input.nextInt();
        System.out.print("Enter new marks in Computer: ");
        com = input.nextInt();

        System.out.println("Grades updated successfully.");
        printGradeDetails();
    }

    public void deleteGrade() {
        name = "";
        math = sci = eng = com = 0;

        System.out.println("Grade records deleted successfully.");
    }
}
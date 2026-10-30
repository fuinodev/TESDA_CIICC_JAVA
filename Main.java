
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");

        // Regular Student
        System.out.println("\n===== REGULAR STUDENT =====");

        System.out.print("Enter Name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter Age: ");
        int age1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter Grade 1: ");
        double g1 = sc.nextDouble();

        System.out.print("Enter Grade 2: ");
        double g2 = sc.nextDouble();

        System.out.print("Enter Grade 3: ");
        double g3 = sc.nextDouble();
        sc.nextLine();

        Student regular = new Student(
            name1, age1, id1, g1, g2, g3
        );

        // Scholar Student
        System.out.println("\n===== SCHOLAR STUDENT =====");

        System.out.print("Enter Name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter Age: ");
        int age2 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter Scholarship Name: ");
        String scholarship = sc.nextLine();

        System.out.print("Enter Grade 1: ");
        double sg1 = sc.nextDouble();

        System.out.print("Enter Grade 2: ");
        double sg2 = sc.nextDouble();

        System.out.print("Enter Grade 3: ");
        double sg3 = sc.nextDouble();

        ScholarStudent scholar = new ScholarStudent(
            name2, age2, id2, sg1, sg2, sg3, scholarship
        );

        // POLYMORPHISM
        Person[] students = {regular, scholar};

        System.out.println("\n===== STUDENT RECORDS =====");

        for (Person person : students) {
            person.displayInfo();
            System.out.println("----------------------------");
        }

        sc.close();
    }
}

// ABSTRACTION
abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ENCAPSULATION
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void displayInfo();
}

// INTERFACE
interface GradeCalculator {
    double calculateAverage();
    String getRemarks();
}

// INHERITANCE
class Student extends Person implements GradeCalculator {
    private String studentId;
    private double grade1;
    private double grade2;
    private double grade3;

    public Student(String name, int age, String studentId,
                   double grade1, double grade2, double grade3) {

        super(name, age);

        this.studentId = studentId;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    @Override
    public double calculateAverage() {
        return (grade1 + grade2 + grade3) / 3;
    }

    @Override
    public String getRemarks() {
        if (calculateAverage() >= 75) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("\n===== REGULAR STUDENT =====");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Student ID: " + studentId);
        System.out.printf("Average: %.2f%n", calculateAverage());
        System.out.println("Remarks: " + getRemarks());
    }
}

// INHERITANCE AND POLYMORPHISM
class ScholarStudent extends Student {
    private String scholarshipName;

    public ScholarStudent(String name, int age, String studentId,
                          double grade1, double grade2, double grade3,
                          String scholarshipName) {

        super(name, age, studentId, grade1, grade2, grade3);
        this.scholarshipName = scholarshipName;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n===== SCHOLAR STUDENT =====");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.printf("Average: %.2f%n", calculateAverage());
        System.out.println("Remarks: " + getRemarks());
        System.out.println("Scholarship: " + scholarshipName);

        if (calculateAverage() >= 90) {
            System.out.println("Status: Scholarship Maintained");
        } else {
            System.out.println("Status: For Evaluation");
        }
    }
}

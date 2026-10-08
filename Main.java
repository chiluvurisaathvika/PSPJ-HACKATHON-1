import java.util.Scanner;

class Student {
    String name, course;
    int roll, credits;
    double marks;

    Student(String n, int r, double m, String c, int cr) {
        name = n; roll = r; marks = m; course = c; credits = cr;
    }

    double fee() { return credits * 1500; }
    boolean eligible() { return marks >= 50; }

    double scholarship(double fee) {
        if (marks >= 85) return fee * 0.20;
        if (marks >= 70) return fee * 0.10;
        return 0;
    }

    double finalFee(double fee, double sch) { return fee - sch; }

    void display(double fee, double sch, double finalFee) {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Marks: " + marks);
        System.out.println("Course: " + course);
        System.out.println("Credits: " + credits);
        System.out.println("Total Fee: " + fee);
        System.out.println("Scholarship: " + sch);
        System.out.println("Final Fee: " + finalFee);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Course Name: ");
        String course = sc.nextLine();

        System.out.print("Course Credits: ");
        int credits = sc.nextInt();

        Student s = new Student(name, roll, marks, course, credits);

        if (s.eligible()) {
            double fee = s.fee();
            double sch = s.scholarship(fee);
            double finalFee = s.finalFee(fee, sch);
            s.display(fee, sch, finalFee);
        } else {
            System.out.println("Not eligible for registration.");
        }
    }
}

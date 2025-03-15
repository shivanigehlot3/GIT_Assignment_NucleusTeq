// Object Oriented Programming (OOP):
// Create a class to represent a student with attributes like name, roll number, and marks.
// Implement inheritance to create a "GraduateStudent" class that extends the "Student" class with additional features.

class Student {
    String name;
    int rollNumber;
    double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

class GraduateStudent extends Student {
    String specialization;

    public GraduateStudent(String name, int rollNumber, double marks, String specialization) {
        super(name, rollNumber, marks);
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
    }
}

public class OOP {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 101, 85.5);
        System.out.println("Student Details:");
        student1.displayDetails();

        System.out.println();

        GraduateStudent gradStudent1 = new GraduateStudent("Bob", 201, 92.0, "Data Science");
        System.out.println("Graduate Student Details:");
        gradStudent1.displayDetails();
    }
}

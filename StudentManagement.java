package StudentManagementSystem;

import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove a student
    public boolean removeStudent(String rollNumber) {
        Student toRemove = null;
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                toRemove = student;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            return true; // Successfully removed
        } else {
            return false; // Student not found
        }
    }

    // Method to search for a student
    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to get all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}

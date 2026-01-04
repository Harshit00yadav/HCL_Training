package assignment2.Q5;

import java.util.*;
import java.util.regex.*;

// ===================== STUDENT CLASS =====================
class Student {
    int id;
    String name;
    String course;
    double marks;

    Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + course + " | " + marks;
    }
}

// ===================== INTERFACE =====================
interface StudentOperations {
    void addStudent(Student s) throws Exception;
    void displayStudents();
    void removeStudent(int id);
    Student searchStudent(int id);
    void sortByMarks();
}

// ===================== MANAGER CLASS =====================
class StudentManager implements StudentOperations {

    // Java Collections usage
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();
    Stack<Student> deletedStudents = new Stack<>();

    Map<Integer, Student> studentMap = new HashMap<>();
    Hashtable<Integer, Student> studentTable = new Hashtable<>();
    Set<String> courseSet = new HashSet<>();

    // Add Student (prevents duplicate ID)
    @Override
    public void addStudent(Student s) throws Exception {
        if (studentMap.containsKey(s.id))
            throw new Exception("Duplicate Student ID not allowed!");

        studentList.add(s);
        studentVector.add(s);
        studentMap.put(s.id, s);
        studentTable.put(s.id, s);
        courseSet.add(s.course);
    }

    // Display all students
    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("ID | Name | Course | Marks");
        studentList.forEach(System.out::println);
    }

    // Remove student by ID
    @Override
    public void removeStudent(int id) {
        Student s = studentMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            studentVector.remove(s);
            studentTable.remove(id);
            deletedStudents.push(s); // Stack usage
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search student by ID
    @Override
    public Student searchStudent(int id) {
        return studentMap.get(id);
    }

    // Sort students by marks
    @Override
    public void sortByMarks() {
        studentList.sort(Comparator.comparingDouble(st -> st.marks));
        System.out.println("Students sorted by marks.");
    }

    // Convert HashMap to TreeMap
    public void convertHashMapToTreeMap() {
        TreeMap<Integer, Student> treeMap = new TreeMap<>(studentMap);
        System.out.println("TreeMap (Sorted by Student ID):");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    // Count students course-wise
    public void countStudentsCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Student s : studentList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }
        countMap.forEach((k, v) ->
                System.out.println(k + " : " + v + " students"));
    }

    // Display unique courses
    public void displayCourses() {
        System.out.println("Unique Courses:");
        courseSet.forEach(System.out::println);
    }
}

// ===================== MAIN CLASS =====================
public class Main {

    // REGEX validation for name
    static boolean validateName(String name) {
        return Pattern.matches("[A-Za-z ]+", name);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("""
                \n------ University Student Management System ------
                1. Add Student
                2. Display All Students
                3. Remove Student by ID
                4. Search Student by ID
                5. Sort Students by Marks
                6. Convert HashMap to TreeMap
                7. Count Students Course-wise
                8. Display All Courses
                9. Exit
                ------------------------------------------------
                """);

            try {
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        if (!validateName(name))
                            throw new Exception("Invalid name format (use alphabets only)");

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        manager.addStudent(new Student(id, name, course, marks));
                        System.out.println("Student added successfully.");
                    }

                    case 2 -> manager.displayStudents();

                    case 3 -> {
                        System.out.print("Enter Student ID: ");
                        manager.removeStudent(Integer.parseInt(sc.nextLine()));
                    }

                    case 4 -> {
                        System.out.print("Enter Student ID: ");
                        Student s = manager.searchStudent(Integer.parseInt(sc.nextLine()));
                        System.out.println(s != null ? s : "Student not found.");
                    }

                    case 5 -> manager.sortByMarks();

                    case 6 -> manager.convertHashMapToTreeMap();

                    case 7 -> manager.countStudentsCourseWise();

                    case 8 -> manager.displayCourses();

                    case 9 -> {
                        System.out.println("Exiting system...");
                        sc.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

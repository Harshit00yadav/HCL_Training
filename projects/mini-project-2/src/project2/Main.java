package project2;

import java.util.*;
import java.util.function.Supplier;
import java.io.*;

public class Main {

    private static String dbpath = "./employee.db";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Supplier<Boolean>> menu = new LinkedHashMap<>();
        menu.put("Add Employee", Main::addEmp);
        menu.put("Search Employee by ID", Main::searchEmpId);
        menu.put("Update Employee Salary", Main::updateEmpSalary);
        menu.put("Delete Employee", Main::deleteEmp);
        menu.put("Display Sorted Employees", Main::displaySortedEmp);
        menu.put("Display Departments", Main::displayDepartment);
        menu.put("Exit", () -> true);

        String[] keys = menu.keySet().toArray(new String[0]);

        boolean EXIT = false;
        while (!EXIT) {
            printHeader();
            for (int i = 0; i < keys.length; i++) {
                System.out.printf("\t%d. %s\n", i + 1, keys[i]);
            }
            System.out.print(">>> ");

            try {
                int choice = Integer.parseInt(sc.nextLine()) - 1;
                if (choice < 0 || choice >= keys.length) {
                    System.out.println("Invalid option");
                    continue;
                }
                EXIT = menu.get(keys[choice]).get();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        sc.close();
    }

    public static void printHeader() {
        System.out.println("""
****************************************************
    Welcome To Employee Management System
****************************************************
""");
    }

    // ================= ADD EMPLOYEE =================
    public static boolean addEmp() {
        System.out.print("Employee ID: ");
        String ID = sc.nextLine();
        if (!ID.matches("[0-9]+")) {
            System.out.println("Invalid ID format {use only numbers}");
            return false;
        }

        System.out.print("Employee Name: ");
        String name = sc.nextLine();
        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid name");
            return false;
        }

        System.out.print("Employee Salary: ");
        String salary = sc.nextLine();
        if (!salary.matches("[0-9]+")) {
            System.out.println("Invalid salary");
            return false;
        }

        System.out.print("Employee Department: ");
        String department = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dbpath, true))) {
            bw.write(ID + ", " + name + ", " + salary + ", " + department);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Employee added successfully!");
        return false;
    }

    // ================= SEARCH =================
    public static boolean searchEmpId() {
        System.out.print("Enter Employee ID: ");
        String searchId = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(dbpath))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(searchId + ",")) {
                    System.out.println("Found: " + line);
                    found = true;
                }
            }
            if (!found) System.out.println("Employee not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================= UPDATE SALARY =================
    public static boolean updateEmpSalary() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("New Salary: ");
        String newSalary = sc.nextLine();

        File temp = new File("temp.db");
        boolean updated = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(dbpath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(", ");
                if (p[0].equals(id)) {
                    p[2] = newSalary;
                    updated = true;
                }
                bw.write(String.join(", ", p));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(dbpath).delete();
        temp.renameTo(new File(dbpath));

        System.out.println(updated ? "Salary updated!" : "Employee not found");
        return false;
    }

    // ================= DELETE =================
    public static boolean deleteEmp() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();

        File temp = new File("temp.db");
        boolean deleted = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(dbpath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(id + ",")) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(dbpath).delete();
        temp.renameTo(new File(dbpath));

        System.out.println(deleted ? "Employee deleted!" : "Employee not found");
        return false;
    }

    // ================= SORT =================
    public static boolean displaySortedEmp() {
        List<String[]> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dbpath))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(", "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.sort(Comparator.comparingInt(a -> Integer.parseInt(a[2])));

        System.out.println("\nSorted Employees:");
        for (String[] e : list) {
            System.out.println(String.join(", ", e));
        }
        return false;
    }

    // ================= DEPARTMENTS =================
    public static boolean displayDepartment() {
        Set<String> departments = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dbpath))) {
            String line;
            while ((line = br.readLine()) != null) {
                departments.add(line.split(", ")[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Departments:");
        departments.forEach(System.out::println);
        return false;
    }
}

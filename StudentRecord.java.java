import java.util.Scanner;

class Student {
    int rollnumber;
    String name;
    String course;
    int marks;

    Student(int rollnumber, String name, String course, int marks) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        boolean flag = true;
        Student[] records = new Student[100]; // Assuming a fixed size for records

        int recordCount = 0;

        while (flag) {
            System.out.println("Welcome to Student Record Management System");
            System.out.println("Enter your choice:");
            System.out.println("1. Create a new record");
            System.out.println("2. Insert a student record");
            System.out.println("3. Search a student record");
            System.out.println("4. Delete a student record");
            System.out.println("5. Display all student records");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the details of the student to create a record:");
                    System.out.print("Enter Name of Student: ");
                    String name = sc.next();
                    System.out.print("Enter Roll Number of Student: ");
                    int rollnumber = sc.nextInt();
                    System.out.print("Enter Course of Student: ");
                    String course = sc.next();
                    System.out.print("Enter Total Marks of Student: ");
                    int marks = sc.nextInt();

                    records[recordCount++] = new Student(rollnumber, name, course, marks);

                    System.out.println("Record created successfully.");
                    break;
                }
                case 2: {
                    // Insert a student record (similar to case 1 but with a different approach)
                    System.out.println("Enter the details of the student to insert a record:");
                    System.out.print("Enter Name of Student: ");
                    String name = sc.next();
                    System.out.print("Enter Roll Number of Student: ");
                    int rollnumber = sc.nextInt();
                    System.out.print("Enter Course of Student: ");
                    String course = sc.next();
                    System.out.print("Enter Total Marks of Student: ");
                    int marks = sc.nextInt();

                    records[recordCount++] = new Student(rollnumber, name, course, marks);

                    System.out.println("Record inserted successfully.");
                    break;
                }
                case 3: {
                    // Search a student record by roll number
                    System.out.print("Enter Roll Number of Student whose record you want to search: ");
                    int rollnumber = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < recordCount; i++) {
                        if (records[i].rollnumber == rollnumber) {
                            System.out.println("Student record found:");
                            System.out.println("Roll Number: " + records[i].rollnumber);
                            System.out.println("Name: " + records[i].name);
                            System.out.println("Course: " + records[i].course);
                            System.out.println("Marks: " + records[i].marks);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No such record found.");
                    }

                    break;
                }
                case 4: {
                    // Delete a student record by roll number
                    System.out.print("Enter the Roll Number of the student you want to delete: ");
                    int rollnumber = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < recordCount; i++) {
                        if (records[i].rollnumber == rollnumber) {
                            // Shift the remaining records to fill the gap
                            for (int j = i; j < recordCount - 1; j++) {
                                records[j] = records[j + 1];
                            }
                            recordCount--;
                            found = true;
                            System.out.println("Record deleted successfully.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No such record found.");
                    }

                    break;
                }
                case 5: {
                    // Display all student records
                    if (recordCount == 0) {
                        System.out.println("No records to display.");
                    } else {
                        System.out.println("Displaying all student records:");
                        for (int i = 0; i < recordCount; i++) {
                            System.out.println("Record " + (i + 1) + ":");
                            System.out.println("Roll Number: " + records[i].rollnumber);
                            System.out.println("Name: " + records[i].name);
                            System.out.println("Course: " + records[i].course);
                            System.out.println("Marks: " + records[i].marks);
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("Exiting the program.");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Invalid Choice. Try Again.");
                    break;
                }
            }
        }
    }
}

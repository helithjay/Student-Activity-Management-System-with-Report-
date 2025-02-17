import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;



public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Student[] students = new Student[100];

    public static void main(String[] args) {
        initialise(students);
        System.out.println("1. Check available seats\n" +
                "2. Register student (with ID)\n" +
                "3. Delete student\n" +
                "4. Find student (with student ID)\n" +
                "5. Store student details into a file\n" +
                "6. Load student details from the file to the system\n" +
                "7. View the list of students based on their names\n " +
                "8. Add additional details");


        while (true) {
            System.out.println("Enter what do you want to do (use number): ");
            int whattodo = input.nextInt();

            switch (whattodo) {
                case 1:
                    System.out.println("You typed 1");
                    checkavailablesheets();
                    break;
                case 2:
                    System.out.println("You typed 2");
                    registerstudent();
                    break;
                case 3:
                    System.out.println("You typed 3");
                    deletestudent();
                    break;
                case 4:
                    System.out.println("You typed 4");
                    findstudents();
                    break;
                case 5:
                    System.out.println("You typed 5");
                    storeinfiles();
                    break;
                case 6:
                    System.out.println("You typed 6");
                    loaddetails();
                    break;
                case 7:
                    System.out.println("You typed 7");
                    viewlistofstudents();
                case 8:
                    System.out.println("You typed 8");
                    addadditionaldetails();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    // method to Initialize
    private static void initialise(Student[] students) {
        for (int x = 0; x < students.length; x++) {
            students[x] = null;
        }
        System.out.println("Initialized.");
    }

    //method to check available seats (1)
    private static void checkavailablesheets() {
        for (int i = 0; i < 100; i += 1) {
            if (students[i] == null) {
                System.out.println("seat" + i + "is empty");
            }
        }

    }

    //method to register student (2)
    private static void registerstudent() {
        input.nextLine();

        System.out.println("Enter student ID:");
        String studentID = input.nextLine();


        Student student = new Student();
        student.setStudent_ID(studentID);


        // Add the student to the array
        for (int x = 0; x < students.length; x++) {
            if (students[x] == null) {
                students[x] = student;
                break;
            }
        }
        System.out.println("Student added.");
    }

    //method to delete a student (3)
    private static void deletestudent() {
        input.nextLine();

        System.out.println("Enter  ID to delete:");
        String studentID = input.nextLine();

        for (int x = 0; x < students.length; x++) {
            if (students[x] != null && students[x].getStudent_ID().equals(studentID)) {
                students[x] = null;
                System.out.println("deleted successful");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    //method to find students (4)
    private static void findstudents() {
        input.nextLine();

        System.out.println("Enter  ID to search:");
        String studentID = input.nextLine();

        for (Student student : students) {
            if (student != null && student.getStudent_ID().equals(studentID)) {
                System.out.println("ID: " + student.getStudent_ID());
                return;
            }
        }
        System.out.println("Student ID not found.");
    }


    //method to store data in a file (5)
    private static void storeinfiles() {
        String filePath = "output.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : students) {
                if (student != null) {
                    writer.write(student.getStudent_name() + "," + student.getStudent_ID());

                    for (int i = 0; i < 3; i++) {
                        Module module = student.getModule(i);
                        if (module != null) {
                            writer.write( "," + module.getModuleMarks());

                        } else {
                            writer.write(",No");

                        }
                    }
                    // Write the grade to the text file
                    writer.write("," + student.getGrade());
                    writer.write("\n"); // Separate entries with a blank line for readability
                }
            }
            System.out.println("Student details have been written to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    //method to load details from text file (6)
    private static void loaddetails() {
        try {
            File file = new File("output.txt");
            Scanner file_reader = new Scanner(file);
            int index = 0;
            while (file_reader.hasNextLine()) {
                String line = file_reader.nextLine();
                String[] details = line.split(",");

                if (details.length >= 5) {
                    Student student = new Student();
                    student.setStudent_name(details[0]);
                    student.setStudent_ID(details[1]);

                    for (int i = 0; i < 3; i++) {
                        int moduleMarks = Integer.parseInt(details[2 + i]);
                        Module module = new Module(moduleMarks);
                        student.setModule(i, module);

                    }
                    students[index] = student;
                    index += 1;
                }
            }
            file_reader.close();
            System.out.println("Data loaded");
        } catch (IOException e) {
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }
    }

    //method for view students
    private static void viewlistofstudents() {
        for (int i = 0; i < 100; i += 1) {
            if(students[i] != null) {
                System.out.println("Student ID: "+students[i].getStudent_ID());
                System.out.println("Student name: "+students[i].getStudent_name());
            }
        }
    }

    //method to add additional details (8)
    private static void addadditionaldetails() {


        System.out.println("1- add student name\n" + "2- Add module marks\n"+"3- Summary\n"+"4- Report");
        System.out.println("What you want to do");
        int choose = input.nextInt();
        input.nextLine();
        switch (choose) {
            case 1:
                //to add student name
                System.out.println("Enter student ID to manage details:");
                String studentID = input.nextLine();
                for (Student student : students) {
                    if (student != null && student.getStudent_ID().equals(studentID)) {
                        System.out.println("Enter student name:");
                        String studentname = input.nextLine();
                        student.setStudent_name(studentname);
                        System.out.println("Student name updated.");
                        return;
                    }
                }
                break;
            case 2:
                //to add marks of 3 module
                System.out.println("Enter student ID to manage details:");
                studentID = input.nextLine();
                for (Student student : students) {
                    if (student != null && student.getStudent_ID().equals(studentID)) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("Enter module " + (i + 1) + " marks:");
                            int moduleMarks = input.nextInt();
                            input.nextLine();
                            Module module = new Module(moduleMarks);
                            student.setModule(i, module);
                        }
                        System.out.println("Module details updated.");
                        return;
                    }
                }
                System.out.println("Student ID not found.");
                break;
            case 3:
                // to print The total of registered students
                int count1 =0;
                for(int i = 0;i < 100;i += 1){
                    if(students[i] != null){
                        count1 += 1;
                    }
                }
                System.out.println("Number of Regitered Students: "+count1);
                int count2 =0;
                for(int i = 0;i < 100;i += 1){
                    if(students[i] != null && "Pass".equals(students[i].getGrade())){
                        count2 += 1;
                    }
                }

                System.out.println("Number of Pass Students: "+count2);

            case 4:
                //to print report
                for(int i = 0;i < 100;i += 1){
                    if(students[i] != null){
                        System.out.println("ID of student: "+students[i].getStudent_ID());
                        System.out.println("Name of student: "+students[i].getStudent_name());

                        int[] moduleMarks = students[i].getModuleMarks();
                        System.out.println("Marks of module 1: "+moduleMarks[0]);
                        System.out.println("Marks of module 2: "+moduleMarks[1]);
                        System.out.println("Marks of module 3: "+moduleMarks[2]);
                        double total = (moduleMarks[0] + moduleMarks[1] + moduleMarks[2])/3;
                        System.out.println("Total of marks: "+total);
                        double average = total/3;
                        System.out.println("Average of marks: "+average);
                        System.out.println("Grade: "+students[i].getGrade());





                    }
                }






        }



    }
}




# Student Management System

## Overview
This project is a simple **Student Management System** implemented in Java. It allows users to manage student details, including registration, deletion, retrieval, and storing student data in files.

## Features
- **Check Available Seats**: View empty seats in the student array.
- **Register Student**: Add a student using a unique ID.
- **Delete Student**: Remove a student from the system.
- **Find Student**: Search for a student using their ID.
- **Store Student Details**: Save student data to a text file.
- **Load Student Details**: Retrieve student data from a text file.
- **View Student List**: Display students with their names.
- **Add Additional Details**:
  - Add student name.
  - Add module marks.
  - View student summary.
  - Generate a student report.

## Project Structure
```
StudentManagementSystem/
│── src/
│   ├── Main.java
│   ├── Student.java
│   ├── Module.java
│── output.txt  (Generated file for student data storage)
│── Task 3.iml
│── README.md
```

## Classes
### 1. **Main.java**
Handles the main operations:
- Initializes the student list.
- Provides a menu-driven system for managing students.
- Implements file handling for data storage and retrieval.

### 2. **Student.java**
Defines the **Student** class with attributes:
- `student_ID`
- `student_name`
- `modules[]` (Array storing marks for 3 modules)

Includes methods for:
- Setting and retrieving student details.
- Calculating the average marks.
- Determining the student's grade.

### 3. **Module.java**
Defines the **Module** class to store marks for individual modules.

## How to Run the Program
1. **Compile the Code:**
   ```sh
   javac Main.java Student.java Module.java
   ```
2. **Run the Program:**
   ```sh
   java Main
   ```
3. Follow the on-screen menu to interact with the system.

## Data Storage
- The program saves student data in `output.txt`.
- The format follows: `StudentName,StudentID,Module1Marks,Module2Marks,Module3Marks,Grade`

## Improvements & Future Enhancements
- Improve file handling with JSON or a database.
- Implement a GUI for better user interaction.
- Add authentication for student access.
- Implement sorting and filtering features.

## License
This project is open-source and free to use for educational purposes.


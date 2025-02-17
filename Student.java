class Student {
    private String student_ID;
    private String student_name;
    private Module[] modules = new Module[3]; // Array to store marks for three modules

    // Constructor
    public Student() {
        this.student_ID = student_ID;
        this.student_name = student_name;
    }

    // Getter and Setter methods for modules
    public Module getModule(int index) {
        return modules[index];
    }

    public void setModule(int index, Module module) {
        this.modules[index] = module;
    }

    // Getter methods for student ID
    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    // Method to calculate the average
    public double calculateAverageMarks() {
        int totalMarks = 0;
        int moduleCount = 0;
        for (Module module : modules) {
            if (module != null) {
                totalMarks += module.getModuleMarks();
                moduleCount++;
            }
        }
        return moduleCount > 0 ? (double) totalMarks / moduleCount : 0;
    }

    // Method to get the grade
    public String getGrade() {
        double averageMarks = calculateAverageMarks();
        if (averageMarks >= 80) {
            return "Distinction";
        } else if (averageMarks >= 70) {
            return "Merit";
        } else if (averageMarks >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public int[] getModuleMarks() {
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            if (modules[i] != null) {
                marks[i] = modules[i].getModuleMarks();
            }
        }
        return marks;
    }








}

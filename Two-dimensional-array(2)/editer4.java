class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    public int gradeLevel;

    public Student(String studentId, String firstName, String lastName, int gradeLevel) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}

class Classroom {
    Student[] students;
    private String courseName;
    private int period;
    private int roomNumber;
    public String teacher;

    public Classroom(Student[] students, String courseName, int period, int roomNumber, String teacher) {
        this.students = students;
        this.courseName = courseName;
        this.period = period;
        this.roomNumber = roomNumber;
        this.teacher = teacher;
    }

    public String getClassIdentity() {
        return this.courseName + " room " + this.roomNumber + " during period " + this.period + " managed by "
                + this.teacher;
    }

    public int getNumberOfStudents() {
        return this.students.length;
    }
}
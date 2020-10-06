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

class Main {
    public static Void printSchoolSchedule(Classroom[] classrooms){
        for (int i = 0; i < classrooms.length; i++){
            Classroom classroom = classrooms[i];
            System.out.println(classroom.getClassIdentity());
            String studentString = "";
            for (int j = 0; j < classroom.students.length; j++){
                Student student = classroom.students[j];
                studentString += student.getFullName() + ",";
            }
            studentString += classroom.students[classroom.getNumberOfStudents()-1].getFullName()
            System.out.println("Student list: " + studentString);
        }
    }
    public static void main(String[] args) {
        Classroom classroom1 = new Classroom(new Student[]{new Student("AC-343424","Vincent", "Lynch",10), new Student("AC-343434","Violet", "Marshall",10),new Student("AC-343428","Aubree", "Lambert",10),new Student("AC-343454","Danny", "Robertson",10)}, "Algebra II", 2, 23, "Emily Theodore");
        Classroom classroom2 = new Classroom(new Student[]{new Student("AC-340014","Kent", "Carter",11), new Student("AC-340024","Isaiah", "Chambers",11),new Student("AC-340018","Leta", "Ferguson",11)}, "English", 5, 104, "Daniel Pherb");

        Classroom classroom3 = new Classroom(new Student[]{new Student("AC-330010","Glenda", "Soto",12), new Student("AC-330035","Johnny", "Robertson",12),new Student("AC-330020","Ava", "Hansen",12), new Student("AC-340084","Nathaniel", "Romero",11)}, "Biology", 5, 36, "Maki Watanabe");

        Classroom[] school = new Classroom[]{classroom1, classroom2, classroom3};
        printSchoolSchedule(school);
    }
    
}


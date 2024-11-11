import java.io.*;
import java.util.ArrayList;
import java.util.List;

class UTM{
    private List<Student> students;
    private List<Faculty> faculties;
    private List<String> fields;

    public UTM() {
        this.faculties = new ArrayList<>();
        this.students = new ArrayList<>();
        this.fields = new ArrayList<>();
    }

    public void saveStudentsToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Student student : students) {
            writer.write(student.toString());
            writer.newLine();
        }
        writer.close();
    }

    public void saveFacultyToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Faculty faculty : faculties) {
            writer.write(faculty.toString());
            writer.newLine();
        }
        writer.close();
    }

    public void loadFacultiesFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (!fields.contains(parts[2])) {
                fields.add(parts[2]);
            }
            faculties.add(new Faculty(parts[0], parts[1], parts[2]));
        }
        reader.close();
    }

    public void loadStudentsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            String[] parts = line.split(",");
            boolean graduated = parts[3].equals("1");
            students.add(new Student(parts[0], parts[1], parts[2], graduated));
        }
        reader.close();
    }

    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public Faculty getFacultyByShortName(String facultyShortName) {
        for (Faculty faculty : faculties) {
            if (faculty.getShortName().equals(facultyShortName)) {
                return faculty;
            }
        }
        return null;
    }

    public void assignStudentToFaculty(String studentId, String facultyShortName) {
        Student student = getStudentById(studentId);
        if (student != null) {
            Faculty faculty = getFacultyByShortName(facultyShortName);
            if (faculty != null) {
                student.setFaculty(facultyShortName);
                faculty.addStudent(student);
            }
        }
        Loger.logAction("Student " + studentId + " transferat la faculatea " + facultyShortName);
    }

    public void graduateStudent(String studentId) throws IOException {
        Student student = getStudentById(studentId);
        if (student != null) {
            student.graduate();
        }
        Loger.logAction("Student " + studentId + " absolbvit");
    }
    public boolean studentExists(String studentId) {
        return getStudentById(studentId) != null;
    }

    public boolean facultyExists(String facultyShortName) {
        return getFacultyByShortName(facultyShortName) != null;
    }

    public boolean fieldExists(String field) {
        return fields.contains(field);
    }

    public boolean studentInFaculty(String studentId, String facultyShortName) {
        Student student = getStudentById(studentId);
        return student != null && student.getFaculty().equals(facultyShortName);
    }

    public void displayFaculties() {
        if(faculties != null) {
            for (Faculty faculty : faculties) {
                System.out.println(faculty.getShortName() + ":" + faculty.getLongName() + " - " + faculty.getField());
            }
        }
        else{
            System.out.println("EROARE: NU exista facultati");
            Loger.logError("NU exista facultati");
        }
    }

    public void displayFields(){
        if(fields != null) {
            for (String field : fields) {
                System.out.println(field);
            }
        }
        else{
            System.out.println("EROARE: Nu exista specilaitati");
            Loger.logError("Nu exista specilaitati");
        }
    }

    public void displayStudents() {
        if(students != null) {
            for (Student student : students) {
                System.out.print(student.getId() + ": " + student.getName() + " " + student.getFaculty() + " ");
                if (student.isGraduated()) {
                    System.out.println(" Absolvit");
                } else {
                    System.out.println(" Nu a absolvit");
                }
            }
        }
        else{
            System.out.println("EROARE:Nu exisa studenti");
            Loger.logError("Nu exisa studenti");
        }
    }

    public void displayFacultiesByField(String field) {
        for (Faculty faculty : faculties) {
            if (faculty.getField().equals(field)) {
                System.out.println(faculty.getLongName());
            }
        }
    }

    public void displayStudentsInFaculty(String facultyShortName) {
        for(Student student : students) {
            if(studentInFaculty(student.getId(),facultyShortName)) {
                System.out.println(student.getId() + ": " + student.getName());
            }
        }
    }
}

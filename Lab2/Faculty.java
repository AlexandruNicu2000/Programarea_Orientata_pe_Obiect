import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String nameLong;
    private String nameShort;
    private String field;
    private List<Student> students;

    public Faculty(String nameShort, String nameLong, String field) {
        this.nameShort = nameShort;
        this.nameLong = nameLong;
        this.field = field;
        this.students = new ArrayList<Student>();
    }

    public String getLongName() {
        return nameLong;
    }

    public String getShortName() {
        return nameShort;
    }

    public String getField() {
        return field;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return nameShort + "," + nameLong + "," + field;
    }
}


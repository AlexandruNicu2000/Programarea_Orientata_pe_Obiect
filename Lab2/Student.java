class Student{
    private String id;
    private String name;
    private String facultyShort;
    private boolean graduated;

    public Student(String id, String name, String faculty, boolean graduated) {
        this.id = id;
        this.name = name;
        this.facultyShort = faculty;
        this.graduated = graduated;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return facultyShort;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void graduate() {
        this.graduated = true;
    }

    public void setFaculty(String faculty) {
        this.facultyShort = faculty;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + facultyShort + "," + (graduated ? "1" : "0");
    }
}

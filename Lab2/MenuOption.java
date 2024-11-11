import java.util.Scanner;

public class MenuOption {

    private UTM utm;
    private Loger loger;
    public MenuOption(UTM utm, Loger loger) {
        this.utm = utm;
        this.loger = loger;
    }

    public void OptionDisplayStudents() {
        try {
            System.out.println("Studenti");
            utm.displayStudents();
            loger.logAction("Afisarea Studentilor");
        } catch (Exception e) {
            System.out.println("EROARE: problema la afisarea studentilor");
            loger.logError("Problema la afisarea studentilor");
        }
    }

    public void OptiondDisplayFaculties() {
        try {
            System.out.println("Facultatile");
            utm.displayFaculties();
            loger.logAction("Afisarea Facultatilor");
        } catch (Exception e) {
            System.out.println("EROARE: problema la afisarea facultatilor");
            loger.logError("Problema la afisarea facultatilor");
        }
    }

    public void OptionDisplayFields() {
        try {
            System.out.println("Specialitatile");
            utm.displayFields();
            loger.logAction("Afisarea Specialitati");
        } catch (Exception e) {
            System.out.println("EROARE: problema la afisarea specialitati");
            loger.logError("Problema la afisarea specialitati");
        }
    }

    public void OptionGraduateStudent(Scanner scanner) {
        try {
            loger.logAction("Scaner pentru student");
            System.out.println("Introdu ID-ul studentului: ");
            String studentId = scanner.next();
            if (utm.studentExists(studentId)) {
                utm.graduateStudent(studentId);
            } else {
                System.out.println("EROARE: Nu existe acest student");
                loger.logError("Nu exista acest student");
            }
        } catch (Exception e) {
            System.out.println("ERROR: Eroare la scrierea sdudentului");
            loger.logError("la scrierea sdudentului");
        }
    }

    public void OptionAssignStudentToFaculty(Scanner scanner) {
        loger.logAction("Scaner pentru Student");
        System.out.println("Introdu ID-ul studentului:");
        String studentId = scanner.next();
        loger.logAction("Scanner pentru abrevieri");
        System.out.println("Introdu Abrevierea Facultati:");
        String shortName = scanner.next();

        if (utm.studentExists(studentId) && utm.facultyExists(shortName)) {
            utm.assignStudentToFaculty(studentId, shortName);
        } else {
            System.out.println("EROARE: Citire incorecta");
            loger.logError("Citire incorecta");
        }
    }

    public void OptionDisplayFacultiesByField(Scanner scanner) {
        loger.logAction("Scaner pentru specialitate");
        System.out.println("Introdu specialitatea:");
        String field = scanner.next();
        if (utm.fieldExists(field)) {
            utm.displayFacultiesByField(field);
        } else {
            System.out.println("EROARE: Nu exista specilaitatea");
            loger.logError("Nu exista specilaitatea");
        }
    }

    public void OptionDisplayStudentsInFaculty(Scanner scanner) {
        loger.logAction("Scaner pentru facultate");
        System.out.println("Introdu Facultatea: ");
        String faculty = scanner.next();
        if (utm.facultyExists(faculty)) {
            utm.displayStudentsInFaculty(faculty);
        } else {
            System.out.println("EROARE: Nu existe facultate");
            loger.logError("Nu exista facultate");
        }
    }

    public void OptionExitProgram() {
        try {
            utm.saveStudentsToFile("resources/students.txt");
            utm.saveFacultyToFile("resources/faculty.txt");
            loger.logAction("Programul finisat");
        } catch (Exception e) {
            System.out.println("ERRORE: La salvarea fisierelor");
            loger.logError("La salvarea fisierelor");
        }
    }}

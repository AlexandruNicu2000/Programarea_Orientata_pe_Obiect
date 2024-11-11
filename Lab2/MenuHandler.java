import java.util.Scanner;
import java.io.IOException;

public class MenuHandler {
    private UTM utm;
    private Loger loger;
    private MenuOption options;

    public MenuHandler(UTM utm, Loger loger, MenuOption options) {
        this.utm = utm;
        this.loger = loger;
        this.options = options;
    }

    public void handleMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);

        loger.logAction("Programul a inceput");
        try {
            utm.loadFacultiesFromFile("resources/faculty.txt");
            utm.loadStudentsFromFile("resources/students.txt");
            System.out.println("Fisierre citite cu succes");
            loger.logAction("Fisierre citite cu succes");
        } catch (Exception e) {
            System.out.println("EROARE: problema la citirea fisierelor");
            loger.logError("Problema la citirea fisierelor");
        }

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1.Afisarea Studentilor");
            System.out.println("2.Afisarea Facultatilor");
            System.out.println("3.Afisarea Specialitati");
            System.out.println("4.Absolva un Student");
            System.out.println("5.Transfera student la o facultate");
            System.out.println("6.Afiseaza facultatea dupa specialitate");
            System.out.println("7.Afisarea studentilor dupa facultate");
            System.out.println("8.Iesire");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    options.OptionDisplayStudents();
                    break;
                case 2:
                    options.OptiondDisplayFaculties();
                    break;
                case 3:
                    options.OptionDisplayFields();
                    break;
                case 4:
                    options.OptionGraduateStudent(scanner);
                    break;
                case 5:
                    options.OptionAssignStudentToFaculty(scanner);
                    break;
                case 6:
                    options.OptionDisplayFacultiesByField(scanner);
                    break;
                case 7:
                    options.OptionDisplayStudentsInFaculty(scanner);
                    break;
                case 8:
                   options.OptionExitProgram();
                    return;
                default:
                    System.out.println("EROARE: Optiune invalida");
                    loger.logError("Optiune invalida");
            }
        }
    }


}



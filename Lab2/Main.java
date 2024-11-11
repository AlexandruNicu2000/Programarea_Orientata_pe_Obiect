import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UTM utm = new UTM();
        Loger loger = new Loger();
        MenuOption options = new MenuOption(utm, loger);
        MenuHandler menuHandler = new MenuHandler(utm, loger, options);
        menuHandler.handleMenu();
    }
}

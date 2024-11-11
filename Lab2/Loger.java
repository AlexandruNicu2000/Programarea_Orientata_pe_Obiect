import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loger {
    private static final String LOG_FILE = "resources/logs.txt";
    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logAction(String action) {
        try {
            writer.write(getTimestamp() + " ACTION: " + action);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logError(String error) {
        try {
            writer.write(getTimestamp() + " ERROR: " + error);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}


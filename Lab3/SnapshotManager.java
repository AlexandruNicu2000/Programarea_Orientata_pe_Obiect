import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SnapshotManager {

    private static final String SNAPSHOT_FILE = "snapshot.txt";
    private final Map<String, String> fileHashes = new HashMap<>();

    public Map<String, String> getFileHashes() {
        return fileHashes;
    }

    public void saveSnapshot() {
        File snapshotFile = new File(SNAPSHOT_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(snapshotFile))) {
            for (Map.Entry<String, String> entry : fileHashes.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Snapshot saved to: " + snapshotFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving snapshot: " + e.getMessage());
        }
    }

    public void loadSnapshot() {
        fileHashes.clear();
        File snapshotFile = new File(SNAPSHOT_FILE);
        if (!snapshotFile.exists()) {
            System.out.println("No previous snapshot found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(snapshotFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    fileHashes.put(parts[0], parts[1]);
                }
            }
            System.out.println("Snapshot loaded from: " + snapshotFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error loading snapshot: " + e.getMessage());
        }
    }
}


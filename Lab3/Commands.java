import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Commands {

    private static final String MONITORED_FOLDER = "C:\\path\\to\\folder"; // Update to your folder path
    private final SnapshotManager snapshotManager;

    public Commands(SnapshotManager snapshotManager) {
        this.snapshotManager = snapshotManager;
    }

    public void commit() {
        System.out.println("Committing changes...");
        Map<String, String> fileHashes = snapshotManager.getFileHashes();
        fileHashes.clear();
        try {
            Files.walk(Paths.get(MONITORED_FOLDER))
                    .filter(Files::isRegularFile)
                    .forEach(path -> fileHashes.put(path.toString(), FileUtils.calculateHash(path.toFile())));
            System.out.println("Snapshot updated.");
        } catch (IOException e) {
            System.out.println("Error during commit: " + e.getMessage());
        }
    }

    public void info(String filename) {
        File file = new File(MONITORED_FOLDER, filename);
        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return;
        }

        System.out.println("Filename: " + filename);
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Last Modified: " + file.lastModified());
        System.out.println("Size: " + file.length() + " bytes");
    }

    public void status() {
        System.out.println("File status since last snapshot:");
        try {
            Map<String, String> fileHashes = snapshotManager.getFileHashes();
            Files.walk(Paths.get(MONITORED_FOLDER))
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        String currentHash = FileUtils.calculateHash(path.toFile());
                        String previousHash = fileHashes.get(path.toString());
                        if (currentHash.equals(previousHash)) {
                            System.out.println(path.getFileName() + ": Unchanged");
                        } else {
                            System.out.println(path.getFileName() + ": Changed");
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error during status check: " + e.getMessage());
        }
    }
}


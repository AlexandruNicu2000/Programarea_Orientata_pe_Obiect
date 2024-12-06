import java.util.Scanner;

public class FileMonitor{

    public static void main(String[] args) {
        SnapshotManager snapshotManager = new SnapshotManager();
        Commands commands = new Commands(snapshotManager);

        snapshotManager.loadSnapshot();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Git File Monitor Program");
        String command;

        while (true) {
            System.out.print("\nEnter a command (git commit, git info <filename>, git status, git exit): ");
            command = scanner.nextLine().trim();

            if (!command.startsWith("git ")) {
                System.out.println("Invalid command. All commands must start with 'git'.");
                continue;
            }

            String[] parts = command.split(" ", 2);
            String gitCommand = parts.length > 1 ? parts[1] : "";

            if (gitCommand.equals("commit")) {
                commands.commit();
            } else if (gitCommand.startsWith("info")) {
                String[] infoParts = gitCommand.split(" ", 2);
                if (infoParts.length > 1) {
                    commands.info(infoParts[1]);
                } else {
                    System.out.println("Usage: git info <filename>");
                }
            } else if (gitCommand.equals("status")) {
                commands.status();
            } else if (gitCommand.equals("exit")) {
                snapshotManager.saveSnapshot();
                System.out.println("Snapshot saved. Exiting program.");
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}




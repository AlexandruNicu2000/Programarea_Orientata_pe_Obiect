import java.io.*;
import java.security.MessageDigest;

public class FileUtils {

    public static String calculateHash(File file) {
        try (InputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            while ((length = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, length);
            }
            byte[] hash = digest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error calculating hash", e);
        }
    }
}

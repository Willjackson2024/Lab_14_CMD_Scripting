import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FileScan {
    public static void main(String[] args) {
        try {
            String filePath;

            if (args.length > 0) {
                filePath = args[0];
                System.out.println("Scanning file from command-line argument: " + filePath);
            } else {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    filePath = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    System.out.println("No file selected. Exiting.");
                    return;
                }
            }

            String content = Files.readString(Path.of(filePath));
            int charCount = content.length();
            int wordCount = content.split("\\s+").length;
            int lineCount = content.split("\r?\n").length;

            System.out.printf("Characters: %d\nWords: %d\nLines: %d\n", charCount, wordCount, lineCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

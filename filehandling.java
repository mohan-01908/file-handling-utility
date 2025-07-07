import java.io.*;
import java.util.Scanner;

/**
 * FileHandlingUtility demonstrates basic file operations: write, read, and modify.
 * Internship Task - 1 for CodTech
 */
public class FileHandlingUtility {

    private static final String FILE_NAME = "example.txt";

    // Write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("📄 File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(">> " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Modify a file by replacing a specific word
    public static void modifyFile(String oldWord, String newWord) {
        try {
            // Read original content
            StringBuilder contentBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line.replaceAll(oldWord, newWord)).append("\n");
            }
            reader.close();

            // Write modified content back
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(contentBuilder.toString());
            writer.close();

            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate all operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Write
        System.out.println("Enter content to write into file:");
        String content = scanner.nextLine();
        writeFile(content);

        // Step 2: Read
        readFile();

        // Step 3: Modify
        System.out.println("Enter word to be replaced:");
        String oldWord = scanner.nextLine();
        System.out.println("Enter new word:");
        String newWord = scanner.nextLine();
        modifyFile(oldWord, newWord);

        // Step 4: Read again
        readFile();

        scanner.close();
    }
}

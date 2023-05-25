import java.io.*;
import java.util.*;

public class ScoreManager {
    private static final String FILE_PATH = "./src/scores.txt";

    public void addScore(String studentName, String courseName, double score) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(studentName + "," + courseName + "," + score);
            writer.newLine();
            writer.close();
            System.out.println("Score added successfully!");
        } catch (IOException e) {
            System.out.println("Unable to add score: " + e.getMessage());
        }
    }

    public void deleteScore(String studentName, String courseName) {
        try {
            File inputFile = new File(FILE_PATH);
            File tempFile = new File("./src/temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (!data[0].equals(studentName) || !data[1].equals(courseName)) {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println("Score deleted successfully!");
        } catch (IOException e) {
            System.out.println("Unable to delete score: " + e.getMessage());
        }
    }

    public void updateScore(String studentName, String courseName, double newScore) {
        try {
            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (data[0].equals(studentName) && data[1].equals(courseName)) {
                    data[2] = String.valueOf(newScore);
                    currentLine = String.join(",", data);
                }
                writer.write(currentLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println("Score updated successfully!");
        } catch (IOException e) {
            System.out.println("Unable to update score: " + e.getMessage());
        }
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StudentLogin {
    static File FILE_PATH = new File("./src/", "user_credentials.txt");
    public static boolean login(String username, String password) {
        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            System.out.println("Username and password cannot be empty");
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                String storedUsername = credentials[0].trim();
                String storedPassword = credentials[1].trim();

                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    System.out.println("Login successful");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred. Please try again later");
            return false;
        }
        System.out.println("Invalid username or password");
        return false;
    }
}


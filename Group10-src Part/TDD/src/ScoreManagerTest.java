import org.junit.*;
import java.io.*;
import java.nio.file.*;

public class ScoreManagerTest {
    private static final String TEST_FILE_PATH = "./src/test_scores.txt";
    private static final String ORIGINAL_FILE_PATH = "./src/scores.txt";

    private ScoreManager scoreManager;

    @Before
    public void setUp() {
        scoreManager = new ScoreManager();
    }

    @Test
    public void testAddScore() throws IOException {
        scoreManager.addScore("John Doe", "Math", 90);
        scoreManager.addScore("Jane Smith", "English", 85);

        String expectedContent = "John Doe,Math,90\nJane Smith,English,85\n";
        String actualContent = readFileContent();

        Assert.assertEquals(expectedContent, actualContent);
    }

    @Test
    public void testDeleteScore() throws IOException {
        // Create a test file for the initial state
        createTestFile();

        scoreManager.deleteScore("Jane Smith", "English");

        String expectedContent = "John Doe,Math,90\n";
        String actualContent = readFileContent();

        Assert.assertEquals(expectedContent, actualContent);

        // Restore the original file
        restoreOriginalFile();
    }

    @Test
    public void testUpdateScore() throws IOException {
        // Create a test file for the initial state
        createTestFile();

        scoreManager.updateScore("Jane Smith", "English", 98);

        String expectedContent = "John Doe,Math,90\nJane Smith,English,98\n";
        String actualContent = readFileContent();

        Assert.assertEquals(expectedContent, actualContent);

        // Restore the original file
        restoreOriginalFile();
    }

    private String readFileContent() throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(TEST_FILE_PATH));
        return new String(fileBytes);
    }

    private void createTestFile() throws IOException {
        Files.copy(Paths.get(ORIGINAL_FILE_PATH), Paths.get(TEST_FILE_PATH), StandardCopyOption.REPLACE_EXISTING);
    }

    private void restoreOriginalFile() throws IOException {
        Files.copy(Paths.get(ORIGINAL_FILE_PATH), Paths.get(TEST_FILE_PATH), StandardCopyOption.REPLACE_EXISTING);
    }
}

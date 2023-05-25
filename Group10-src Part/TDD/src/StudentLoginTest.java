import org.junit.Assert;
import org.junit.Test;

public class StudentLoginTest {

    @Test
    public void testValidCredentials() {
        Assert.assertTrue(StudentLogin.login("john", "111111"));
    }

    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(StudentLogin.login("jane", "password"));
    }

    @Test
    public void testInvalidPassword() {
        boolean result = StudentLogin.login("john", "wrongpassword");
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidCredentials() {
        boolean result = StudentLogin.login("jane", "wrongpassword");
        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyCredentials() {
        boolean result = StudentLogin.login("", "");
        Assert.assertFalse(result);
    }

    @Test
    public void testNullCredentials() {
        boolean result = StudentLogin.login(null, null);
        Assert.assertFalse(result);
    }

    @Test
    public void testWhitespaceCredentials() {
        boolean result = StudentLogin.login("  ", "  ");
        Assert.assertFalse(result);
    }
}

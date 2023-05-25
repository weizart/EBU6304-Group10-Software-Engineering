public class whiteboxtest {
    public static void main(String[] args) {
        testValidCredentials();
        testInvalidUsername();
        testInvalidPassword();
        testInvalidCredentials();
        testEmptyCredentials();
        testNullCredentials();
        testWhitespaceCredentials();
    }

    private static void testValidCredentials() {
        boolean result = StudentLogin.login("john", "password");
        System.out.println("testValidCredentials: " + result);
    }

    private static void testInvalidUsername() {
        boolean result = StudentLogin.login("jane", "password");
        System.out.println("testInvalidUsername: " + result);
    }

    private static void testInvalidPassword() {
        boolean result = StudentLogin.login("john", "wrongpassword");
        System.out.println("testInvalidPassword: " + result);
    }

    private static void testInvalidCredentials() {
        boolean result = StudentLogin.login("jane", "wrongpassword");
        System.out.println("testInvalidCredentials: " + result);
    }

    private static void testEmptyCredentials() {
        boolean result = StudentLogin.login("", "");
        System.out.println("testEmptyCredentials: " + result);
    }

    private static void testNullCredentials() {
        boolean result = StudentLogin.login(null, null);
        System.out.println("testNullCredentials: " + result);
    }

    private static void testWhitespaceCredentials() {
        boolean result = StudentLogin.login("  ", "  ");
        System.out.println("testWhitespaceCredentials: " + result);
    }
}

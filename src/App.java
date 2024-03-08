import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static boolean validatePassword(String password) {
        // Check length
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check for at least three out of four categories
        int categories = 0;
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[~!@#$%^&*()-=+_]");

        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);
        Matcher specialCharMatcher = specialCharPattern.matcher(password);

        if (lowerCaseMatcher.find()) {
            categories++;
        }
        if (upperCaseMatcher.find()) {
            categories++;
        }
        if (digitMatcher.find()) {
            categories++;
        }
        if (specialCharMatcher.find()) {
            categories++;
        }

        return categories >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password:");
        String password = scanner.nextLine();

        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }

        scanner.close();
    }
}
import Exceptions.InvalidLengthException;

public class PasswordValidator {

    public static void isValidPassword(String password) throws Exception {
        if (password.length() < 5) {
            throw new InvalidLengthException("The length of the password must be at least 5 characters");
        }
        System.out.println("Password is valid");
    }
}

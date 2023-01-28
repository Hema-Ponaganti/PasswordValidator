import Exceptions.InvalidLengthException;
import Exceptions.MissingCharacterException;

public class PasswordValidator {

    public static void isValidPassword(String password) throws Exception {
        if (password.length() < 5) {
            throw new InvalidLengthException("The length of the password must be at least 5 characters");
        }
        if (!password.matches(".*[a-zA-Z]+.*")){
            throw new MissingCharacterException("The password must contain at least 1 letter");
        }
        if(!password.matches(".*\\d.*")){
            throw new MissingCharacterException("The password must contain at least 1 digit");
        }
        System.out.println("Password is valid");
    }
}

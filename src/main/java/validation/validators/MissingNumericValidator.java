package validation.validators;

import Exceptions.InvalidPasswordException;
import validation.PasswordValidator;

public class MissingNumericValidator implements PasswordValidator {
    private PasswordValidator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if(!password.matches(".*\\d.*")){
            throw new InvalidPasswordException("The password must contain at least 1 digit");
        }
        else {
            System.out.println("Password is valid");
        }
    }

    @Override
    public void setNext(PasswordValidator validator) {
        this.next = validator;
    }
}

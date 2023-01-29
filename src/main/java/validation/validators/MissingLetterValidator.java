package validation.validators;

import Exceptions.InvalidPasswordException;
import validation.PasswordValidator;

public class MissingLetterValidator implements PasswordValidator {
    private PasswordValidator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if (!password.matches(".*[a-zA-Z]+.*")){
            throw new InvalidPasswordException("The password must contain at least 1 letter");
        }
        else {
            next.validate(password);
        }
    }

    @Override
    public void setNext(PasswordValidator validator) {
        this.next = validator;
    }
}

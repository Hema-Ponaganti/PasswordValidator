package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

public class AdminLengthValidator implements Validator {
    private Validator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("The length of the password must be at least 5 characters");
        } else {
            next.validate(password);
        }
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

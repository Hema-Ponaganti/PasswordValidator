package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

public class AdminLengthValidator implements Validator {
    private Validator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if (password.length() < 9) {
            throw new InvalidPasswordException("Admin passwords must be at least 9 characters in length");
        } else {
            next.validate(password);
        }
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

public class LengthValidator implements Validator {
    private Validator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if (password.length() < 5) {
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

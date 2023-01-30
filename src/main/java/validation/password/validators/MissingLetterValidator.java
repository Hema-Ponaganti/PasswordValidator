package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

public class MissingLetterValidator implements Validator {
    private Validator next;

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
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

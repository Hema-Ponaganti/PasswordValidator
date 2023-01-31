package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

import java.util.ArrayList;
import java.util.List;

public class MissingLetterValidator implements Validator {
    private Validator next;

    @Override
    public List<InvalidPasswordException> validate(String password) {
        List<InvalidPasswordException> exceptions = new ArrayList<>();

        if (!password.matches(".*[a-zA-Z]+.*")){
            exceptions.add(new InvalidPasswordException("The password must contain at least 1 letter"));
        }
        exceptions.addAll(next.validate(password));
        return exceptions;
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

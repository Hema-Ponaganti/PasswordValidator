package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

import java.util.ArrayList;
import java.util.List;

public class AdminLengthValidator implements Validator {
    private Validator next;


    @Override
    public List<InvalidPasswordException> validate(String password) {
        List<InvalidPasswordException> exceptions = new ArrayList<>();

        if (password.length() < 9) {
            exceptions.add(new InvalidPasswordException("Admin passwords must be at least 9 characters in length"));
        }
        exceptions.addAll(next.validate(password));
        return exceptions;
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

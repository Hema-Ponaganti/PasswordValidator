package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

import java.util.ArrayList;
import java.util.List;

public class LengthValidator implements Validator {
    private Validator next;
    private int length;

    public LengthValidator(int length){
        this.length = length;
    }

    @Override
    public List<InvalidPasswordException> validate(String password) {
        List<InvalidPasswordException> exceptions = new ArrayList<>();

        if (password.length() < length) {
            exceptions.add(new InvalidPasswordException("The length of the password must be at least 5 characters"));
        }
        exceptions.addAll(next.validate(password));
        return exceptions;

    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

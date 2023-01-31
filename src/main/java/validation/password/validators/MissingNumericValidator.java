package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

import java.util.ArrayList;
import java.util.List;

public class MissingNumericValidator implements Validator {
    private Validator next;

    @Override
    public List<InvalidPasswordException> validate(String password) {
        List<InvalidPasswordException> exceptions = new ArrayList<>();

        if(!password.matches(".*\\d.*")){
            exceptions.add(new InvalidPasswordException("The password must contain at least 1 digit"));
        }
        return exceptions;
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

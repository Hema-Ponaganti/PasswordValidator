package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;
import java.util.ArrayList;
import java.util.List;

public class MissingSpecialCharacterValidator implements Validator {
    private Validator next;

    @Override
    public List<InvalidPasswordException> validate(String password) {
        List<InvalidPasswordException> exceptions = new ArrayList<>();

        if(!password.matches(".*[!@#$%^&*+=-_].*")){
            exceptions.add(new InvalidPasswordException("Admin passwords must contain at least 1 special character"));
        }
        return exceptions;
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

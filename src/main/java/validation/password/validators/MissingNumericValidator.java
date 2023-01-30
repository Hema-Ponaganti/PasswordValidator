package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

public class MissingNumericValidator implements Validator {
    private Validator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if(!password.matches(".*\\d.*")){
            throw new InvalidPasswordException("The password must contain at least 1 digit");
        }
        else {
            System.out.println("Password is valid");
        }
    }

    @Override
    public void setNext(Validator validator) {
        this.next = validator;
    }
}

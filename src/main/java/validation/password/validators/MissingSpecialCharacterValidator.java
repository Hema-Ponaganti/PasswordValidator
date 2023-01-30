package validation.password.validators;

import Exceptions.InvalidPasswordException;
import validation.password.Validator;

public class MissingSpecialCharacterValidator implements Validator {
    private Validator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if(!password.matches(".*[!@#$%^&*+=-_].*")){
            throw new InvalidPasswordException("Admin passwords must contain at least 1 special character");
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

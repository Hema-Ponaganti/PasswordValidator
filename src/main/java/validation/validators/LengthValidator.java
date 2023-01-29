package validation.validators;

import Exceptions.InvalidPasswordException;
import jdk.nashorn.internal.objects.annotations.Constructor;
import validation.PasswordValidator;

public class LengthValidator implements PasswordValidator {
    private PasswordValidator next;

    @Override
    public void validate(String password) throws InvalidPasswordException {
        if (password.length() < 5) {
            throw new InvalidPasswordException("The length of the password must be at least 5 characters");
        } else {
            next.validate(password);
        }
    }

    @Override
    public void setNext(PasswordValidator validator) {
        this.next = validator;
    }
}

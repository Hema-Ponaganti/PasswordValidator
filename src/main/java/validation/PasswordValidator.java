package validation;

import Exceptions.InvalidPasswordException;

public interface PasswordValidator {
    void validate(String password) throws InvalidPasswordException;
    void setNext(PasswordValidator validator);
}

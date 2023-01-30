package validation.password;

import Exceptions.InvalidPasswordException;

public interface Validator {
    void validate(String password) throws InvalidPasswordException;
    void setNext(Validator validator);
}

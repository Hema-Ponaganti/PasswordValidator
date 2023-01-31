package validation.password;

import Exceptions.InvalidPasswordException;
import java.util.List;

public interface Validator {
    List<InvalidPasswordException> validate(String password);
    void setNext(Validator validator);
}

import Exceptions.InvalidPasswordException;
import validation.password.ValidatorChain;

import java.util.List;

public class PasswordValidation {
    ValidatorChain validatorChain;

    public PasswordValidation() {
        this.validatorChain = new ValidatorChain();
    }

    public void validate(String password, Role userRole) throws InvalidPasswordException {
        List<InvalidPasswordException> exceptions;
        if (userRole == Role.ADMIN) {
            exceptions = validatorChain.buildAdminChain().validate(password);

        } else {
            exceptions = validatorChain.buildUserChain().validate(password);
        }
        if (!exceptions.isEmpty()){
            for(InvalidPasswordException exception: exceptions){
                throw exception;
            }
        }
    }
}


import Exceptions.InvalidPasswordException;
import validation.password.ValidatorChain;

public class PasswordValidation {
    ValidatorChain validatorChain;

    public PasswordValidation() {
        this.validatorChain = new ValidatorChain();
    }

    public void validate(String password, Role userRole) throws InvalidPasswordException {
        if (userRole == Role.ADMIN) {
            validatorChain.buildAdminChain().validate(password);

        } else if (userRole == Role.USER) {
            validatorChain.buildUserChain().validate(password);
        }
    }
}

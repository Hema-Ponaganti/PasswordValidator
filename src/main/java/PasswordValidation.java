import Exceptions.InvalidPasswordException;
import validation.PasswordValidator;
import validation.ValidatorChain;

public class PasswordValidation {
    PasswordValidator chain;

    public PasswordValidation() {
        ValidatorChain validatorChain = new ValidatorChain();
        this.chain = validatorChain.build();
    }

    public void validate(String password) throws InvalidPasswordException {
        chain.validate(password);
    }
}

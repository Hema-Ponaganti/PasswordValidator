package validation.password;

import validation.password.validators.AdminLengthValidator;
import validation.password.validators.MissingNumericValidator;
import validation.password.validators.MissingSpecialCharacterValidator;
import validation.password.validators.LengthValidator;
import validation.password.validators.MissingLetterValidator;

public class ValidatorChain {
    public Validator buildUserChain() {
        LengthValidator lengthValidator = new LengthValidator();
        MissingLetterValidator missingLetterValidator = new MissingLetterValidator();
        MissingNumericValidator missingNumericValidator = new MissingNumericValidator();

        lengthValidator.setNext(missingLetterValidator);
        missingLetterValidator.setNext(missingNumericValidator);

        return lengthValidator;
    }
    public Validator buildAdminChain() {
        AdminLengthValidator lengthValidator = new AdminLengthValidator();
        lengthValidator.setNext(new MissingSpecialCharacterValidator());

        return lengthValidator;
    }
}

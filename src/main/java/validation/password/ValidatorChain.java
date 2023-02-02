package validation.password;

import validation.password.validators.LengthValidator;
import validation.password.validators.MissingLetterValidator;
import validation.password.validators.MissingNumericValidator;
import validation.password.validators.MissingSpecialCharacterValidator;

public class ValidatorChain {
    public Validator buildUserChain() {
        LengthValidator lengthValidator = new LengthValidator(5);
        MissingLetterValidator missingLetterValidator = new MissingLetterValidator();
        MissingNumericValidator missingNumericValidator = new MissingNumericValidator();

        lengthValidator.setNext(missingLetterValidator);
        missingLetterValidator.setNext(missingNumericValidator);

        return lengthValidator;
    }
    public Validator buildAdminChain() {
        LengthValidator lengthValidator = new LengthValidator(8);
        lengthValidator.setNext(new MissingSpecialCharacterValidator());

        return lengthValidator;
    }
}

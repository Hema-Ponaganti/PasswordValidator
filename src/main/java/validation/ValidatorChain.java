package validation;

import validation.validators.LengthValidator;
import validation.validators.MissingLetterValidator;
import validation.validators.MissingNumericValidator;

public class ValidatorChain {
    public PasswordValidator build() {
        LengthValidator lengthValidator = new LengthValidator();
        MissingLetterValidator missingLetterValidator = new MissingLetterValidator();
        MissingNumericValidator missingNumericValidator = new MissingNumericValidator();

        lengthValidator.setNext(missingLetterValidator);
        missingLetterValidator.setNext(missingNumericValidator);

        return lengthValidator;
    }
}

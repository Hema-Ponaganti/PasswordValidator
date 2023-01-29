import Exceptions.InvalidPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidationTest {

    PasswordValidation passwordValidation = new PasswordValidation();

    @Test
    void shouldVerifyIfLengthOfPasswordIsAtLeastFive() {

        assertDoesNotThrow(() -> passwordValidation.validate("pass01"));
    }


    @Test
    void shouldThrowInvalidLengthExceptionIfPasswordLengthIsLessThanFive() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("pass"));
    }

    @Test
    void shouldNotThrowExceptionIfPasswordHasALetter() {

        assertDoesNotThrow(() -> passwordValidation.validate("123a123"));
    }

    @Test
    void shouldThrowMissingCharacterExceptionIfPasswordDoesNotHaveAtLeastOneLetter() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("12345"));
    }

    @Test
    void shouldNotThrowExceptionIfPasswordHasADigit() {

        assertDoesNotThrow(() -> passwordValidation.validate("password1"));
    }

    @Test
    void shouldThrowMissingCharacterExceptionIfPasswordDoesNotHaveAtLeastOneDigit() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("password"));
    }
}

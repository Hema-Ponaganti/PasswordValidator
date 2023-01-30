import Exceptions.InvalidPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidationTest {

    PasswordValidation passwordValidation = new PasswordValidation();

    @Test
    void shouldVerifyIfGivenUserPasswordIsValid() {

        assertDoesNotThrow(() -> passwordValidation.validate("pass01", Role.USER));
    }

    @Test
    void shouldThrowInvalidPasswordExceptionIfPasswordLengthIsLessThanFive() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("pass", Role.USER));
    }

    @Test
    void shouldThrowExceptionIfPasswordDoesNotHaveAtLeastOneLetter() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("12345", Role.USER));
    }

    @Test
    void shouldThrowExceptionIfPasswordDoesNotHaveAtLeastOneDigit() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("password", Role.USER));
    }

    @Test
    void shouldVerifyIfGivenAdminPasswordIsValid() {

        assertDoesNotThrow(() -> passwordValidation.validate("password@01", Role.ADMIN));
    }

    @Test
    void shouldThrowInvalidLengthExceptionIfAdminPasswordLengthIsLessThanNine() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("password", Role.ADMIN));
    }

    @Test
    void shouldThrowExceptionIfPasswordDoesNotHaveAtLeastOneSpecialCharacter() {

        assertThrows(InvalidPasswordException.class, () -> passwordValidation.validate("password01", Role.ADMIN));
    }
}

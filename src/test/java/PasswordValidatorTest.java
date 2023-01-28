import Exceptions.InvalidLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    @Test
    void shouldVerifyIfLengthOfPasswordIsAtLeastFive() {

        assertDoesNotThrow(() -> PasswordValidator.isValidPassword("pass01"));
    }

    @Test
    void shouldThrowInvalidLengthExceptionIfPasswordLengthIsLessThanFive() {

        assertThrows(InvalidLengthException.class, () -> PasswordValidator.isValidPassword("pass"));
    }
}

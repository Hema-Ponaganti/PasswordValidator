import Exceptions.InvalidLengthException;
import Exceptions.MissingCharacterException;

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

    @Test
    void shouldNotThrowExceptionIfPasswordHasALetter(){

        assertDoesNotThrow(() -> PasswordValidator.isValidPassword("123a123"));
    }

    @Test
    void shouldThrowMissingCharacterExceptionIfPasswordDoesNotHaveAtLeastOneLetter(){

        assertThrows(MissingCharacterException.class, () -> PasswordValidator.isValidPassword("12345"));
    }
}

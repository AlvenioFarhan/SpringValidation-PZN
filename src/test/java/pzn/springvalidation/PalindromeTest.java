package pzn.springvalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pzn.springvalidation.data.Foo;

import java.util.Set;

@SpringBootTest
public class PalindromeTest {

    @Autowired
    private Validator validator;

    @Test
    void palindromeValid() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("kodok"));
        Assertions.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void palindromeInvalid() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("alvenio"));
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(1, constraintViolations.size());
    }

    @Test
    void palindromeInvalidMessages() {
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("alvenio"));
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(1, constraintViolations.size());

        String message = constraintViolations.stream().findFirst().get().getMessage();
        Assertions.assertEquals("Data bukan palindrome", message);
    }
}

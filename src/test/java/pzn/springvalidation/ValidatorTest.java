package pzn.springvalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pzn.springvalidation.data.Person;

import java.util.Set;

@SpringBootTest
public class ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void personNotValid() {
        Person person = new Person("","");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(2, constraintViolations.size());
    }

    @Test
    void personValid() {
        Person person = new Person("1","Alvenio");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertTrue(constraintViolations.isEmpty());
    }
}

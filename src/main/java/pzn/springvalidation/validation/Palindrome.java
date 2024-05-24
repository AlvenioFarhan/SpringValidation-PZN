package pzn.springvalidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {PalindromeValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Palindrome {

    String message() default "{Palindrome.messages}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

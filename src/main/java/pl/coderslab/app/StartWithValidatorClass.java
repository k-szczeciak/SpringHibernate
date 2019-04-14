package pl.coderslab.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidatorClass implements ConstraintValidator<StartWith, String> {

    private String toCheck;

    @Override
    public void initialize(StartWith startWith) {
        this.toCheck = startWith.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.startsWith(toCheck);
    }
}

package nl.itris.decadeschermen.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
        	
        	BeanWrapperImpl wrapper = new BeanWrapperImpl(value);
        	final Object firstObj = wrapper.getPropertyValue(firstFieldName);
           	final Object secondObj = wrapper.getPropertyValue(secondFieldName);
                   	
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}
        return true;
    }
}
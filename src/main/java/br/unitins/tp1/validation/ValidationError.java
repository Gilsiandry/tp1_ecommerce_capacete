package br.unitins.tp1.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    public ValidationError(String code, String message) {
        
    }

    private record FieldError(String fieldName, String message) {
    };

    private List<FieldError> errors = null;

    public List<FieldError> getErrors() {
        return errors;
    }

    public void addFieldError(String fieldName, String message) {
        if (errors == null) {
            errors = new ArrayList<>();
        }

        errors.add(new FieldError(fieldName, message));
    }

    @Override
    public String toString() {
        return errors.toString();
    }

}
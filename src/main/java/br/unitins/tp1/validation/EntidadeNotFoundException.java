package br.unitins.tp1.validation;

public class EntidadeNotFoundException {
    private String fieldName;
    private String message;

    public EntidadeNotFoundException(String fieldName, String message) {
        
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
    public String getMessage() {
        return message;
    }
}

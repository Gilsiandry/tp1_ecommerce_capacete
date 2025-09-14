package br.unitins.tp1.validation;

public class EntidadeNotFoundException {
    private String fieldName;

    public EntidadeNotFoundException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}

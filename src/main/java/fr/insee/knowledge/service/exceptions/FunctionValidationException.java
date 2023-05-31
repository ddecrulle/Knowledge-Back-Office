package fr.insee.knowledge.service.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class FunctionValidationException extends RuntimeException {
    private final List<String> errorMessages;

    public FunctionValidationException(String message, List<String> errorMessages) {
        super(message);
        this.errorMessages = errorMessages;
    }
}

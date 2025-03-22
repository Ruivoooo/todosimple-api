package com.lucasangelo.todosimple.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final int status;
    private final String message;
    private String stackTrace;
    private List<ValidationError> errors;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Getter
    @Setter
    private static class ValidationError{
        private final String field;
        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }


    public void addValidationError(String field, String message) {
        if (Objects.isNull(errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(new ValidationError(field, message));
    }



}

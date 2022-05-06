package com.milita.task.application.validation;

import org.springframework.web.server.ServerWebInputException;

public class InternetPackageException extends ServerWebInputException {
    public InternetPackageException(String reason) {
        super(reason);
    }
}

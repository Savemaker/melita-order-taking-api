package com.melita.task.application.authentication;

public interface AuthenticationService {
    void checkAuthentication(String authHeader);
}

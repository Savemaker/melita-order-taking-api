package com.melita.task.application.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class SimpleStubAuthenticationServiceImplementation implements AuthenticationService {
    @Value("${AUDIENCE:melita}")
    private String audienceValue;
    private static final int PAYLOAD = 1;
    private static final String JWT_REGEX_SPLITTER = "\\.";
    private static final String AUDIENCE_KEY = "aud";
    private final ObjectMapper objectMapper;

    @Override
    public void checkAuthentication(String authHeader) {
        if (authHeader == null || authHeader.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Have not received auth header");
        }
        String payload = authHeader.split(JWT_REGEX_SPLITTER)[PAYLOAD];
        if (payload == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Have not received JWT payload");
        }
        Base64.Decoder decoder = Base64.getUrlDecoder();
        try {
            String jsonPayloadString = new String(decoder.decode(payload));
            JsonNode jsonNode = objectMapper.readTree(jsonPayloadString);
            if (!jsonNode.get(AUDIENCE_KEY).textValue().equals(audienceValue)) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Nice try, Mr. Hackerman");
            }
        } catch (JsonProcessingException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Error processing the jwt payload");
        }
    }
}

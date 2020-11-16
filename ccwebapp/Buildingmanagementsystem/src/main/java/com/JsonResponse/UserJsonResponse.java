package com.JsonResponse;

import com.pojo.User;

import java.util.Map;

public class UserJsonResponse {
    public boolean isValidated() {
        return validated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    private User user;
    private boolean validated;
    private Map<String, String> errorMessages;
}


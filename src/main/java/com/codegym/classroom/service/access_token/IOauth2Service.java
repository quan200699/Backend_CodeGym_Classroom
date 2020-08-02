package com.codegym.classroom.service.access_token;

import com.codegym.classroom.model.AccessToken;

public interface IOauth2Service {
    AccessToken getAccessToken(String clientId, String clientSecret, String redirectUri, String code, String state);
}

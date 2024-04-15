package com.cache.api.jersey;

import com.cache.api.service.UserService;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class APIApplication extends ResourceConfig {
    public APIApplication() {
        register(UserService.class);
        register(JacksonJsonProvider.class);
    }
}

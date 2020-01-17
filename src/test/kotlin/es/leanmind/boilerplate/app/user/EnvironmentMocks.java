package es.leanmind.boilerplate.app.user;


import org.mockito.ArgumentMatchers;
import org.springframework.core.env.Environment;

import static org.mockito.Mockito.when;

public class EnvironmentMocks {
    public void initMocks(Environment environment){
        when(environment.getProperty(ArgumentMatchers.anyString())).thenReturn("password_key");
    }
}

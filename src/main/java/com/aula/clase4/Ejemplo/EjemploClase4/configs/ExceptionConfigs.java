package com.aula.clase4.Ejemplo.EjemploClase4.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
@Data
@Component
@ConfigurationProperties(prefix="exception")
public class ExceptionConfigs {
    private Map<String ,String> exception;
    public static final String PERSONALIZADA= "se presento un error en el sistema";
    public static final String SYSTEM= "error en el sistema";

    public String getException (String key){
        return exception.get(key);
    }
}

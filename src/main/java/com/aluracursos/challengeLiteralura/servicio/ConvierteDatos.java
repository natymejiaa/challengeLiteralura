package com.aluracursos.challengeLiteralura.servicio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConvierteDatos implements IConvierteDatos {

    private final ObjectMapper objectMapper;


    @Autowired
    public ConvierteDatos(ObjectMapper objectMapper) { this.objectMapper = objectMapper; }


    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new DataConversionException("Error al convertir JSON a " + clase.getName(), e);
        }
    }
}


class DataConversionException extends RuntimeException {


    public DataConversionException(String message, Throwable cause) { super(message, cause); }
}

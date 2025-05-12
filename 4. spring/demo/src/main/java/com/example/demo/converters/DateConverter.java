package com.example.demo.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateConverter implements Converter<LocalDateTime, String> {

    @Override
    public String convert(LocalDateTime localDateTime) {
        LocalDate date = localDateTime.toLocalDate();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return date.format(pattern);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}

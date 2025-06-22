package com.italooliveira.app_agendamento.backend.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter BRAZIL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String formatarParaPadraoBrasileiro(LocalDateTime localDateTime) {
        return BRAZIL_DATE_TIME_FORMATTER.format(localDateTime);
    }
}

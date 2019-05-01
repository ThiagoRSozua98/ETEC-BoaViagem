package br.com.etechoracio.etec_boaviagem.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtils {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatDate(int dia, int mes, int ano){
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(ano, mes, dia);
            return DATE_FORMAT.format(cal.getTime());
        } catch (Exception e){
            return null;
        }
    }
 }


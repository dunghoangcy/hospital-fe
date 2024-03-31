package com.lsd.web.util;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.ErrorMessageLoader;
import com.lsd.web.exception.WebException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Common {
    public static boolean isValidDateFormat(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime.parse(str, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static LocalDateTime convertStringToLocalDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return dateTime;
    }

    public static boolean isValidDateFormatPatient(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            formatter.parse(dateString);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new WebException(ErrorCode.DATE_VALID, ErrorMessageLoader.getMessage("LSD-YYYYMMDD"));
        }
        return date;
    }
    public static boolean isValidPhone(String str) {
        Pattern pattern = Pattern.compile("(84|0[3|9])+([0-9]{8})\\b");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int getYearNow(){
        LocalDateTime localDate = LocalDateTime.now();
        int year = localDate.getYear();
        return year;
    }
    public static Date getDateNow(){
        Date date = new Date();
        return date;
    }
}

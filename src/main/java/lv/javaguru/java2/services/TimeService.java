package lv.javaguru.java2.services;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AST on 2015.11.27..
 */
@Component
public class TimeService {
    private java.sql.Timestamp timestamp;

    public TimeService(){
        timestamp = getSqlTimestamp();
    }

    public java.sql.Timestamp getSqlTimestamp(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());
        return sqlTimestamp;
    }

    public java.sql.Timestamp getStartOfDateTimestamp(){
        java.util.Date utilDate = new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utilDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return sqlTimestamp;
    }

    public java.sql.Timestamp setStartOfDateTimestamp(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return sqlTimestamp;
    }

    public java.sql.Timestamp getEndOfDateTimestamp(){
        java.util.Date utilDate = new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utilDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return sqlTimestamp;
    }

    public java.sql.Timestamp setEndOfDateTimestamp(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date stopDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stopDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return sqlTimestamp;
    }

    public java.sql.Timestamp subtractDays(java.sql.Timestamp timestamp, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.DAY_OF_YEAR, -day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return sqlTimestamp;
    }

    public String getFormattedDate(Date date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(date);
        return formattedDate;
    }
}

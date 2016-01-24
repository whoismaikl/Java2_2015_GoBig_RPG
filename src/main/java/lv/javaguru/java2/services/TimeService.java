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

    public java.sql.Timestamp getStartDateTimestamp(){
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
    public Date subtractDays(Date date, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -day);
        return calendar.getTime();
    }

    public String getFormattedDate(Date date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(date);

        return formattedDate;
    }
}

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
    public Date getChangedDate(Date date, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }

    public Date getFormatedDate() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(new Date());
        Date date = df.parse(formattedDate);
        return date;
    }
}

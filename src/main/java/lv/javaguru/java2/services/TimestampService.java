package lv.javaguru.java2.services;

/**
 * Created by AST on 2015.11.27..
 */
public class TimestampService {
    private java.sql.Timestamp timestamp;
    public TimestampService(){
        timestamp = getSqlTimestamp();
    }
    public java.sql.Timestamp getSqlTimestamp(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());
        return sqlTimestamp;
    }
}
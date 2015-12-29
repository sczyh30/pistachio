package org.samsara.pistachio.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Samsara Common Library
 * Date util class
 * @author sczyh30
 */
public class DateUtil {

    /**
     * A method that could convert Date object to String
     * default format -> (yyyy-MM-dd)
     * @param date the date string
     * @return date object
     * @throws ParseException
     */
    public static Date toDate(String date) throws ParseException {
        return toDate(date, false);
    }

    /**
     * A method that could convert Date object to String
     * @param date the date string
     * @param accurate if this flag is true, the date string should be
     *                 accurate to minute(yyyy-MM-dd hh:mm)
     *                 or else it should be accurate to day(yyyy-MM-dd)
     * @return date object
     * @throws ParseException
     */
    public static Date toDate(String date, Boolean accurate) throws ParseException {
        DateFormat df;
        if(accurate)
            df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        else
            df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(date);
    }

    /**
     * Get the current timestamp
     * @return timestamp
     */
    public static Timestamp getStamp() {
        return Timestamp.valueOf(LocalDateTime.now());
    }
}

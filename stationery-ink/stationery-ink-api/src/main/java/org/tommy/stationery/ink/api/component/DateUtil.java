package org.tommy.stationery.ink.api.component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 10..
 */
public class DateUtil {

    private static SimpleDateFormat hourFormat = new SimpleDateFormat("yyyyMMddHH");

    public static Long getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        String dt = hourFormat.format(cal.getTime());
        return Long.valueOf(dt);
    }

    public static List<Long> getBetweenDateList(Long beginDt, Long endDt) {
        Calendar cal = Calendar.getInstance();
        Date date = null;
        try {
            date = hourFormat.parse(String.valueOf(beginDt));
        } catch (ParseException e) {
        }
        cal.setTime(date);

        List<Long> dateList = new ArrayList<Long>();

        for (int i=0;i<24*2;i++) {
            String dt = hourFormat.format(cal.getTime());
            dateList.add(Long.valueOf(dt));

            cal.add(Calendar.HOUR_OF_DAY, 1);
            if (dt.equals(String.valueOf(endDt))) break;
        }

        return dateList;
    }
}

package org.tommy.stationery.ink.udf.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Monitoring {
	
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
	
	public static String isFiltered(String msg, String[] errorWordSet) {
        for (String errorWord : errorWordSet) {
                if ( msg.toUpperCase().contains(errorWord.toUpperCase())) return "FILTER";
        }

        return "NO_FILTER";
	}
	
    public static String sendNoti(String group, String title, String level, String host, String path, String message) {
        Calendar calendar = Calendar.getInstance();
        String date = dateFormat.format(calendar.getTime());
        String msg = "[" + title + "]" + "\n"
                + "*레벨: " + level + "\n"
                + "*서버: " + host + "\n"
                + "*장애시간: " + date + "\n"
                + "*대상: " + path + "\n"
                + "*내용: " + message + "\n"
                + "*장애해결 : "  + "\n"
                + "   1. 해당서버의 로그를 확인하고 잡의 상태를 확인한다." + "\n"
                + "   2. http://play.daumcorp.com/display/bizdmp/119 장애대응페이지를 참고한다.";
        InkKakaoAlert.kakaoAlert(group, msg);
        return msg;
    }
}

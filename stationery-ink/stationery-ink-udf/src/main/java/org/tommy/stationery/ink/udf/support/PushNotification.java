package org.tommy.stationery.ink.udf.support;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import javapns.Push;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotifications;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kun7788 on 15. 4. 22..
 */
public class PushNotification {

    private static PushNotificationPayload payload = null;
    private static Sender sender = null;

    public static String pushAPN(String certificate, String password, String udid, String message, Map<String, String> extra) {
        try {
            if (payload == null) {
                payload = PushNotificationPayload.complex();
            }
            PushNotificationPayload payload = PushNotificationPayload.complex();
            payload.addAlert(message);
            payload.addBadge(-1);
            payload.addSound("default");

            if( extra != null ) {
                Iterator<String> keys = extra.keySet().iterator();
                while( keys.hasNext() ) {
                    String key = keys.next();
                    String value = extra.get(key);

                    payload.addCustomDictionary(key, value);
                }
            }

            PushedNotifications notifications = Push.payload(payload,
                    certificate, password, /*production*/true, udid);

            if (notifications != null && notifications.size() > 0 && notifications.get(0).isSuccessful()) {
                return "SUCCEED";
            }
            return "FAILED";

        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public static String pushGCM(String apiKey, String token, String message, Map<String, String> extra) {
        if (sender == null) {
            sender = new Sender(apiKey);
        }

        try { message = URLEncoder.encode(message, "UTF-8"); }
        catch (UnsupportedEncodingException ignore) {return ignore.getMessage();}

        Message.Builder messageBuilder = new Message.Builder();
        messageBuilder.delayWhileIdle(false);
        messageBuilder.timeToLive(1800); // 30min
        messageBuilder.addData("msg", message);

        if( extra != null ) {
            Iterator<String> keys = extra.keySet().iterator();
            while( keys.hasNext() ) {
                String key = keys.next();
                String value = extra.get(key);

                messageBuilder.addData(key, value);
            }
        }

        try {
            Result result = sender.send(messageBuilder.build(), token, 5);
            String messageId = result.getMessageId();
            if (messageId == null) return "FAILED";
            return "SUCCEED";
        } catch(Exception e) {
            return e.getMessage();
        }
    }

}

package cn.zhumengqi.es.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by zhumengqi on 17-5-1.
 */
public class CusDateUtil {
    //    TODO:检查是否导致日期-1
    private static SimpleDateFormat sdfStand = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdfES = new SimpleDateFormat("yyyy.MM.dd");
    public static synchronized String timeStampCovertStand(String timeOri) throws Exception {
        if (!NumberUtils.isDigits(timeOri)) {
            throw new Exception("Timestamp error");
        } else {
            String date = null;
            if (timeOri.length() == 10) {
                date = sdfStand.format(new Date(Long.valueOf(Long.valueOf(timeOri).longValue() * 1000L).longValue()));
            } else if (timeOri.length() == 13) {
                date = sdfStand.format(new Date(Long.valueOf(timeOri).longValue()));
            } else {
                if (timeOri.length() <= 13) {
                    throw new Exception("Timestamp error");
                }

                date = sdfStand.format(new Date(Long.valueOf(timeOri.substring(0, 13)).longValue()));
            }

            return date;
        }
    }
    //    TODO:检查是否导致日期-1
    public static synchronized String timeStampCovertES(String timeOri) throws Exception {
        if (!NumberUtils.isDigits(timeOri)) {
            throw new Exception("Timestamp error");
        } else {
            String date = null;
            if (timeOri.length() == 10) {
                date = sdfES.format(new Date(Long.valueOf(timeOri+"000")));
            } else if (timeOri.length() == 13) {
                date = sdfES.format(new Date(Long.valueOf(timeOri)));
            } else {
                if (timeOri.length() <= 13) {
                    throw new Exception("Timestamp error");
                }
                date = sdfES.format(new Date(Long.valueOf(timeOri.substring(0, 13))));
            }

            return date;
        }
    }
}

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Xusj
 * @Date: 2018/8/17
 * @Description:
 */
public class until {
    public static String hex2Str(String hex) {
        StringBuilder sb = new StringBuilder();
        String[] split = hex.split(",");
        for (String str : split) {
            int i = Integer.parseInt(str, 16);
            sb.append((char)i);
        }
        return sb.toString();
    }
    protected static String convertStringToHex(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }
    protected static String convertHexToString(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < hex.length() - 1; i += 2) {
            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }
    public static String hexString2AsciiString(String hex) throws UnsupportedEncodingException {

        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (0xff & Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16));
        }
        return new String(bytes, "UTF-8");
    }


    /**
     * 将String转换为Date
     *
     * @param dateTime
     * @return 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDateTime(String dateTime) {
        return parse(dateTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将String转换为Date
     *
     * @param dateTime 待格式化的字符串
     * @param format   日期格式 请使用DateUtil中的格式常量，如：DEFAULT_DATE_TIME
     * @return
     */
    public static Date parse(String dateTime, String format) {
        if (StringUtils.isBlank(dateTime)) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateTime);
        } catch (ParseException e) {
            throw new RuntimeException("Transform date time String to Date error,dateTime:" + dateTime + ",format:" + format);
        }
    }

    /**
     * 计算两个时间之间相差的秒数，“结束时间”减去“开始时间”之间的秒数.
     *
     * @param compareTime
     * @param currentTime
     * @return int
     */
    public static long secondsBetween(Date compareTime, Date currentTime) {
        if (compareTime == null || currentTime == null) {
            return -1L;
        }
        return ((compareTime.getTime() - currentTime.getTime()) / 1000L);
    }
}

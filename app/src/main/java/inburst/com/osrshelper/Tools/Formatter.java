package inburst.com.osrshelper.Tools;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * lennyhicks
 * 9/6/18
 */
public class Formatter {

    private static DecimalFormat formatter = new DecimalFormat("#,###");
    private static DateFormat dateFormatter = DateFormat.getTimeInstance();

    public static String numberToString(int number) {
        return formatter.format(number);
    }

    public static String formatDate(long timestamp) {
        return dateFormatter.format(new Date(timestamp));
    }
}

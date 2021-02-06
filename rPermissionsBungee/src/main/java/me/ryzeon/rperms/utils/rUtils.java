package me.ryzeon.rperms.utils;

import me.ryzeon.rperms.utils.cache.DataInfo;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 11:39 p. m.
 */

public class rUtils {

    public static DataInfo getInfoFromString(String string) {
        DataInfo dataInfo = new DataInfo();

        final String[] split = string.split(":");
        for (String str : split) {
            String[] itemAttribute = str.split("@");
            String s2 = itemAttribute[0];
            String data = itemAttribute[1];

            switch (s2) {
                case "name":
                    if (data != null) {
                        dataInfo.setName(data);
                    }
                    break;
                case "ptag":
                    if (data != null) {
                        dataInfo.setPrefix(data);
                    }
                    break;
                case "perms":
                    if (data != null) {
                        if (data.equalsIgnoreCase("NONE")) {
                        } else {
                            String[] gamemodeSplit = data.split("-");
                            dataInfo.setPermission(Arrays.asList(gamemodeSplit));
                        }
                    }
                    break;
            }
        }
        return dataInfo;
    }

    public static String millisToSeconds(long millis) {
        return new DecimalFormat("#0.0").format(((float) millis / 1000.0F));
    }

    public static String millisToRoundedTime(long millis) {
        millis++;
        long seconds = millis / 1000L;
        long minutes = seconds / 60L;
        long hours = minutes / 60L;
        long days = hours / 24L;
        long weeks = days / 7L;
        long months = weeks / 4L;
        long years = months / 12L;
        minutes++;
        if (years > 0L) return years + " year" + ((years == 1L) ? "" : "s");
        if (months > 0L) return months + " month" + ((months == 1L) ? "" : "s");
        if (weeks > 0L) return weeks + " week" + ((weeks == 1L) ? "" : "s");
        if (days > 0L) return days + " day" + ((days == 1L) ? "" : "s");
        if (hours > 0L) return hours + " hour" + ((hours == 1L) ? "" : "s");
        if (minutes > 0L) return minutes + " minute" + ((minutes == 1L) ? "" : "s");

        return seconds + " second" + ((seconds == 1L) ? "" : "s");
    }
}

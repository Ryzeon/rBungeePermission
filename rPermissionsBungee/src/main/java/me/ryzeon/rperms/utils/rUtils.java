package me.ryzeon.rperms.utils;

import me.ryzeon.rperms.utils.cache.DataInfo;

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

}

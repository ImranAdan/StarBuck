package org.adani.starbuck.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


public final class DateTimeUtils {


    public static String currentTime(Optional<String> format) {

        if (format.isPresent()) {
            final String dateFormat = format.get();
            return new SimpleDateFormat(dateFormat).format(new Date());
        }

        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }


}

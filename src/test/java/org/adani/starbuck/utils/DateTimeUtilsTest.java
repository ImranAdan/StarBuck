package org.adani.starbuck.utils;


import org.junit.Test;

import java.util.Optional;

import static org.adani.starbuck.utils.DateTimeUtils.currentTime;

public class DateTimeUtilsTest {

    @Test
    public void testGetCurrentTime() throws Exception {
        System.out.println(currentTime(Optional.of("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))); // Print the current time
    }
}
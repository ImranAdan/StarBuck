package org.adani.starbuck.source;

import org.junit.Test;

import static org.adani.starbuck.source.SourceType.H2;
import static org.junit.Assert.assertTrue;

public class SourceTypeTest {

    @Test
    public void testGetDriver() throws Exception {
        SourceType first = H2;
        String second = "H2";
        System.out.println(first.toString());
        System.out.println(SourceType.valueOf(second));
        assertTrue(first == SourceType.valueOf(second));
    }
}
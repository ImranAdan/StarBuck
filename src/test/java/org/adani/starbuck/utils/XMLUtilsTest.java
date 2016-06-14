package org.adani.starbuck.utils;

import org.adani.starbuck.domain.source.Source;
import org.adani.starbuck.domain.source.SourceType;
import org.junit.Test;

public class XMLUtilsTest {

    @Test
    public void testToXMLString() throws Exception {
        Source s = new Source("a", "b", SourceType.H2.getConnector(), "s");
        System.out.print(s.toString());
    }
}
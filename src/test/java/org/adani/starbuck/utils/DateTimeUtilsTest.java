package org.adani.starbuck.utils;

import org.adani.starbuck.data.core.Filter;
import org.adani.starbuck.data.jdbc.TypedJDBCFilter;
import org.adani.starbuck.domain.product.Product;
import org.junit.Test;

public class DateTimeUtilsTest {

    @Test
    public void testGetCurrentTime() throws Exception {
        Filter<Product> filter = new TypedJDBCFilter<>();
        System.out.println(filter.getFilterType());
    }
}
package org.adani.starbuck.utils;

import org.adani.starbuck.domain.product.Product;
import org.junit.Test;

import java.math.BigDecimal;

public class XMLUtilsTest {

    @Test
    public void testToXMLString() throws Exception {
        Product product = new Product();
        product.setName("Nike Running Shoes");
        product.setQuantity(100);
        product.setPrice(new BigDecimal("25.99"));

        System.out.println(XMLUtils.toXMLString(product)); // Should print a formatted XML
    }
}
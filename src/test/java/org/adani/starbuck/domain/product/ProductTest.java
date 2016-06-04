package org.adani.starbuck.domain.product;

import org.junit.Test;

import java.math.BigDecimal;


public class ProductTest {

    @Test
    public void testToString() throws Exception {
        Product product = new Product();

        product.setName("Example Product 1");
        product.setPrice(new BigDecimal("25.99"));
        product.setQuantity(100);
        product.setImageUrl(null);

        System.out.print(product.toString());

    }
}
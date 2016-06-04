package org.adani.starbuck.data.core.models;

import org.adani.starbuck.domain.product.Product;
import org.junit.Test;

import java.math.BigDecimal;

public class PageTest {

    @Test
    public void testToString() throws Exception {
        Page<Product> productPage = new Page<>();


        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(new BigDecimal("25.99"));
        product.setQuantity(100);

        productPage.getElements().add(product);


        System.out.println(productPage.toString());

    }
}
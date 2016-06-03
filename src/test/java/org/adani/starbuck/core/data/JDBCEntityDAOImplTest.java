package org.adani.starbuck.core.data;

import org.adani.starbuck.data.core.models.AbstractEntityFilter;
import org.adani.starbuck.data.core.models.Condition;
import org.adani.starbuck.data.access.jdbc.search.TypedJDBCSearchFilter;
import org.adani.starbuck.data.core.models.AbstractEntityDAO;
import org.adani.starbuck.data.core.models.Operator;
import org.adani.starbuck.domain.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class JDBCEntityDAOImplTest {

    @Autowired
    AbstractEntityDAO<Product> productDAO;

    @Test
    public void testFetchWithItem() throws Exception {

        Product item = new Product();
        item.setName("Fancy Vase");

        AbstractEntityFilter<Product> productFilter = new TypedJDBCSearchFilter.Builder<>(Product.class).addCondition(new Condition("name", Operator.EQUALS, "Fansy Vase")).build();
        Product fetchedItem = productDAO.fetch(productFilter);

        assertThat(fetchedItem.getName(), is(equalTo(item.getName())));

    }

    @Test
    public void testFetchWithSearchCondition() throws Exception {
        fail("Test not yet implemented");

    }

    @Test
    public void testFetchItems() throws Exception {
        fail("Test Not yet implemented");
    }

    @Test
    public void testCreate() throws Exception {
        fail("TEst not yet implemented");
    }

    @Test
    public void testUpdate() throws Exception {
        fail("TEst not yet implemented");
    }

    @Test
    public void testDelete() throws Exception {
        fail("TEst not yet implemented");
    }
}
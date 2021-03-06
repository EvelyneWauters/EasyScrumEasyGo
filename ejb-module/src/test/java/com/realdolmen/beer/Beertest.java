package com.realdolmen.beer;

import com.realdolmen.beer.domain.Product;
import com.realdolmen.beer.domain.Verkoop;
import com.realdolmen.beer.persistence.VerkoopEJB;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 * Created by JVDAX31 on 22/09/2015.
 */
public class Beertest extends DataSetPersistenceTest {
    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Ignore
    @Test
    public void productCanBePersisted() throws Exception {
        Product product = new Product("jupilir vat", 5.0);
        entityManager().persist(product);
        assertNotNull(product.getId());
    }
@Ignore
    @Test(expected = PersistenceException.class)
    public void bookCanNotBePersistedWithoutTitle() throws Exception {

    }
@Ignore
    @Test
    public void bookCanBeRetrievedById() throws Exception {
        Product product = new Product("jupilir fles", 5.0);

        entityManager().persist(product);
        Verkoop verkoop = new Verkoop(product,2);
        entityManager().persist(verkoop);

        assertNotNull(verkoop.getId());
      //  assertEquals("Nineteen Eighty Four", entityManager().find(Product.class, 1000).getName());
    }
}



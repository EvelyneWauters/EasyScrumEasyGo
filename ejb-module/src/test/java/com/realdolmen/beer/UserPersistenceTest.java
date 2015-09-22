package com.realdolmen.beer;

import com.realdolmen.beer.domain.User;
import com.realdolmen.beer.persistence.UserRepository;
import org.junit.Test;

/**
 * Created by EWTAX45 on 22/09/2015.
 */
public class UserPersistenceTest extends DataSetPersistenceTest {

    UserRepository userRepository;

    @Test
    public void testFindAllUsers()  throws Exception    {
        assertNotNull(userRepository.getAllUsers());
    }

    @Test
    public void userCanBePersisted() throws Exception {
        User user = new User("TestPerson", "password");
        entityManager().persist(user);
        assertNotNull(user.getId());
    }

}

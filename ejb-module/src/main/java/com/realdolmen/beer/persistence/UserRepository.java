package com.realdolmen.beer.persistence;

import com.realdolmen.beer.domain.User;
import com.realdolmen.beer.domain.Verkoop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by EWTAX45 on 22/09/2015.
 */
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public void addUser(User user){
        em.persist(user);
    }

    public List<User> getAllUsers()   {
        return em.createQuery("select u from User u", User.class).getResultList();
    }


}

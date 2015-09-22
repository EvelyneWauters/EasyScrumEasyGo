package com.realdolmen.course.consumer;

import com.realdolmen.course.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;

/**
 * Created by EWTAX45 on 9/09/2015.
 */
public class TheoryExplained {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager em = null;

        try {
            em = entityManagerFactory.createEntityManager();
            em.persist(new Book("lala", "lala", Book.Genre.fantasy));
        //gooit een unchecked exception, dus geen catch blok nodig!
        } finally   {
            if(em != null)  {
                em.close();
            }
        }

        entityManagerFactory.close();



        // zeer lelijke code, beter zou zijn:
        //try with resources, zoals bij Streams (sinds Java 7)
        // Gaat jammergenoeg niet voor de entitytmanager
//        try{
//            BufferedReader reader = new BufferedReader();
//            geen idee, tging te snel
//        }
    }
}

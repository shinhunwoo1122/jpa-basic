package org.example;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city", "street", "100000");

            Member member = new Member();
            member.setUserName("hello1");
            member.setHomeAddress(address);
            member.setWorkPeriod(new Period());
            em.persist(member);

            /*Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setUserName("hello1");
            member2.setHomeAddress(copyAddress);
            member2.setWorkPeriod(new Period());
            em.persist(member2);*/



            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }



}

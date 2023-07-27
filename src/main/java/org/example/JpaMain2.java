package org.example;

import javax.persistence.*;

public class JpaMain2 {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /*Address address = new Address("city", "street", "100000");

            Member member = new Member();
            member.setUserName("hello1");
            member.setHomeAddress(address);
            member.setWorkPeriod(new Period());
            em.persist(member);*/

            /*Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setUserName("hello1");
            member2.setHomeAddress(copyAddress);
            member2.setWorkPeriod(new Period());
            em.persist(member2);*/

            Member member = new Member();
            member.setUserName("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            //member.getAddressHistory().add(new Address("old1", "street", "10000"));
            //member.getAddressHistory().add(new Address("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============== START =============== ");
            Member findMember = em.find(Member.class, member.getId());

           /* System.out.println("findMember = " + findMember.getAddressHistory());
            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address.getCity() = " + address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();

            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }
            */
            //homeCity -> newCity
            //findMember.getHomeAddress().setCity("newCity"); (    x   )

            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));

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

package org.example;

import org.hibernate.Hibernate;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*//팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member = new Member();
            member.setName("member1");
            //member.changeTeam(team);
            em.persist(member);

            team.addMember(member);

            //team.getMembers().add(member);

            *//*em.flush();
            em.clear();*//*

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("==============");
            *//*for (Member m : members) {
                System.out.println("m.getName() = " + m.getName());
            }*//*

            System.out.println("findTeam = " + findTeam);
            
            System.out.println("==============");*/

            /*Member member = new Member();
            member.setName("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);*/

            /*Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);*/
            /*Member member = new Member();
            member.setName("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());
            em.persist(member);

            em.flush();
            em.clear();*/

            /*Movie findMovie = (Movie) em.find(Item.class, movie.getId());
            System.out.println("findMovie = " + findMovie);*/

            Member member1 = new Member();
            member1.setName("hello");

            em.persist(member1);

            Member member2 = new Member();
            member2.setName("hello");

            em.persist(member2);

            em.flush();
            em.clear();


            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember.getClass() = " + refMember.getClass()); //Proxy
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            //System.out.println("refMember = " + refMember.getName());



            Hibernate.initialize(refMember); //강제 초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));



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

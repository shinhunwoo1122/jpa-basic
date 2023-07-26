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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setName("member1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("member2");
            member2.setTeam(team2);
            em.persist(member2);


            em.flush();
            em.clear();

            //Member m = em.find(Member.class, member1.getId());

            /*System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());

            System.out.println("======================");
            System.out.println("teamName = " + m.getTeam().getName()); //객체를 가져올시에는 프록시를 가져오고 해당 값을 가져오는것을 터치할시 값을가져옴
            System.out.println("======================");*/

            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();



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

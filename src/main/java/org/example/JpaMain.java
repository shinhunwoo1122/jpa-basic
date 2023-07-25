package org.example;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //팀 저장
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

            /*em.flush();
            em.clear();*/

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("==============");
            /*for (Member m : members) {
                System.out.println("m.getName() = " + m.getName());
            }*/

            System.out.println("findTeam = " + findTeam);
            
            System.out.println("==============");

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

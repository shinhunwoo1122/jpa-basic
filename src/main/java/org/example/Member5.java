package org.example;


import javax.persistence.*;

//@Entity
public class Member5 extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Team team;

    /*@OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;*/

    /*@ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>(); 사용하지 않음 실무에서는*/

    /*@OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();*/


    /*@Column(name = "TEAM_ID")
    private Long teamId;*/

    /*@ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;*/

    public Member5(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /*public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }*/


    /* public Team getTeam() {
        return team;
    }*/

    /*public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }*/

   /* public void setTeam(Team team) {
        this.team = team;
    }*/


}

package org.example;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /*@ManyToMany(mappedBy = "products")
    private List<Member> members = new ArrayList<>(); 실무에서는 사용 안함*/

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

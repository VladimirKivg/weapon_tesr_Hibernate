package hibernate_test2.oneToMany.uni;


import hibernate_test2.oneToMany.uni.Address3;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User3 {
    /*id
     * name
     * adress_id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
//зміни видалили ManyToOne і все що з ним звязанно

    public User3() {
    }

    public User3(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


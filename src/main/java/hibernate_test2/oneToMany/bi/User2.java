package hibernate_test2.oneToMany.bi;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User2 {
    /*id
     * name
     * adress_id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "adress_id")
    private Address2 addressId;

    public User2() {
    }

    public User2(String name) {
        this.name = name;
    }

    public Address2 getAddressId(Address2 address2) {
        return addressId;
    }

    public void setAddressId(Address2 addressId) {
        this.addressId = addressId;
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
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}


package hibernate_test2.oneToMany.uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "adress")
public class Address3 {
    /*id
     * city
     * strit
     * house_number
     * flet_nember
     *  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "city")
    private String city;
    @Column(name = "strit")

    private String street;
    @Column(name = "house_number")
    private int houseNumber;
    @Column(name = "flet_nember")
    private Integer apartmentNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private List<User3> user2s;

    public Address3() {
    }

    public void addUser(User3 user2) {
        if (user2s == null) {
            user2s = new ArrayList<>();
        }
        // це видалили
        user2s.add(user2);


    }

    public Address3(String city, String street, int houseNumber, int apartmentNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public List<User3> getUser2s() {
        return user2s;
    }

    public void setUser2s(List<User3> user2s) {
        this.user2s = user2s;
    }

    @Override
    public String toString() {
        return "Address2{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}

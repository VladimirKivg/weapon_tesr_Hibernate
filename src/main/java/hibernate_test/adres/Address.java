package hibernate_test.adres;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Address {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "city")
    String city;
    @Column(name = "strit")
    String strit;
    @Column(name = "house_number")
    int house_number;
    @Column(name = "flet_nember")
    int flet_nember;

    public Address() {
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

    public String getStrit() {
        return strit;
    }

    public void setStrit(String strit) {
        this.strit = strit;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public int getFlet_nember() {
        return flet_nember;
    }

    public void setFlet_nember(int flet_nember) {
        this.flet_nember = flet_nember;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", strit='" + strit + '\'' +
                ", house_number=" + house_number +
                ", flet_nember=" + flet_nember +
                '}';
    }

    public Address(String city, String strit, int house_number, int flet_nember) {
        this.city = city;
        this.strit = strit;
        this.house_number = house_number;
        this.flet_nember = flet_nember;
    }
}

package hibirnate_test3.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "strit")
    private String strait;

    @Column(name = "hous")
    private Integer house;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agency_and_apartment",
            joinColumns = @JoinColumn(name = "id_apartm"),
            inverseJoinColumns = @JoinColumn(name = "id_agent"))
    private List<Agency> agen;

    public void addAgency(Agency agency) {
        if (agen == null) {
            agen = new ArrayList<>();
        }
        agen.add(agency);
    }

    public Apartment() {
    }

    public Apartment(String city, String strait, Integer house) {
        this.city = city;
        this.strait = strait;
        this.house = house;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStrait() {
        return strait;
    }

    public void setStrait(String strait) {
        this.strait = strait;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public List<Agency> getAgen() {
        return agen;
    }

    public void setAgen(ArrayList<Agency> agen) {
        this.agen = agen;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", strait='" + strait + '\'' +
                ", house=" + house +
                '}';
    }
}

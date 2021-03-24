package hibirnate_test3.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agency")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agency_and_apartment",
            joinColumns = @JoinColumn(name = "id_agent"),
            inverseJoinColumns = @JoinColumn(name = "id_apartm")
    )
    private List<Apartment> apart;

    public void addApartment(Apartment apartment) {
        if (apart == null) {
            apart = new ArrayList<>();
        }
        apart.add(apartment);
    }

    public Agency() {
    }

    public Agency(String name) {
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

    public List<Apartment> getApart() {
        return apart;
    }

    public void setApart(ArrayList<Apartment> apart) {
        this.apart = apart;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apart=" + apart +
                '}';
    }
}

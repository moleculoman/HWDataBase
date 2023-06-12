package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cityId;
    @Column
    String cityName;

    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
package cz.unit.meatfactory.persistence.model;

import javax.persistence.*;

/**
 * Created by Rex on 18.4.2016.
 */
@Entity
@Table(name = "meat")
public class Meat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

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

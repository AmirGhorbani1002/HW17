package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class City extends BaseEntity {

    private String name;
    private String code;
    @OneToMany(mappedBy = "city")
    private Set<Stadium> stadiums;

}

package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City extends BaseEntity {

    private String name;
    private String code;
    @OneToMany(mappedBy = "city")
    private Set<Stadium> stadiums = new HashSet<>();

    public City(String name, String code) {
        this.name = name;
        this.code = code;
    }
}

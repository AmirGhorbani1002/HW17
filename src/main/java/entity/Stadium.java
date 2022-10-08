package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Stadium extends BaseEntity {

    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
    private int numberOfSeats;
    @OneToMany(mappedBy = "stadium")
    private Set<Club> clubs;

}

package entity;

import base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stadium extends BaseEntity {

    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
    private int numberOfSeats;
    @OneToMany(mappedBy = "stadium")
    private Set<Club> clubs;

    public Stadium(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }
}

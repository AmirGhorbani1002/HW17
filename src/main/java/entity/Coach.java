package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Coach extends Person {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Club club;
    private Double value;
    private Double transferValue;
    @Enumerated(EnumType.STRING)
    private SalesStatus salesStatus;
    private Short numberOfWins;
    private Short numberOfLosses;
    private Short numberOfDraws;

}

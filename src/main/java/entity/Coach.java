package entity;

import entity.enums.SalesStatus;
import entity.supers.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

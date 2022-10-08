package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Player extends Person{

    private Byte TShirtNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Club club;
    private Double value;
    private Double transferValue;
    @Enumerated(EnumType.STRING)
    private SalesStatus salesStatus;
    private Short numberOfGoalsScored;
    private Short numberOfYellowCards;
    private Short numberOfRedCards;
    @Enumerated(EnumType.STRING)
    private Position position;

}

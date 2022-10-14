package entity;

import base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Club extends BaseEntity {

    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stadium stadium;
    @OneToOne(fetch = FetchType.LAZY)
    private ClubManager clubManager;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Coach coach;
    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private Set<Player> players = new HashSet<>();
    private Short numberOfWins;
    private Short numberOfLosses;
    private Short numberOfDraws;
    private Short score;

    @OneToOne
    @MapsId
    @Transient
    private Game game;

    public Club(String name, Short numberOfWins, Short numberOfLosses, Short numberOfDraws, Short score) {
        this.name = name;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraws = numberOfDraws;
        this.score = score;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", numberOfWins=" + numberOfWins +
                ", numberOfLosses=" + numberOfLosses +
                ", numberOfDraws=" + numberOfDraws +
                ", score=" + score + "\n";
    }
}

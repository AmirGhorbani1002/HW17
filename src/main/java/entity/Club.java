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
public class Club extends BaseEntity {

    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stadium stadium;
    @OneToOne(fetch = FetchType.LAZY)
    private ClubManager clubManager;
    @OneToOne(fetch = FetchType.LAZY)
    private Coach coach;
    @OneToMany(mappedBy = "club")
    private Set<Player> players;
    private Short numberOfWins;
    private Short numberOfLosses;
    private Short numberOfDraws;

    @OneToOne
    @MapsId
    @Transient
    private Game game;

    public Club(String name) {
        this.name = name;
    }
}

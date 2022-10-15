package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class GameInformation extends BaseEntity {

    @OneToOne
    @MapsId
    private Game game;
    private String winner;
    private Byte numberOfGoals;
    @OneToMany(mappedBy = "gameInformation")
    private Set<PlayersScored> playersScored;
    @OneToMany(mappedBy = "gameInformation")
    private Set<PlayersPlayed> playersPlays;

}

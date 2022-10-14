package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class GameInformation extends BaseEntity {

    @OneToOne
    @MapsId
    private Game game;
    private String winner;
    private Byte numberOfGoals;

}

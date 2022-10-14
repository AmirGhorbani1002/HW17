package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game extends BaseEntity {

    @OneToOne
    private Club home;
    @OneToOne
    private Club away;
    @OneToOne(mappedBy = "game")
    private GameInformation gameInformation;
    private LocalDate localDate;
    private Boolean isFinish;

    public Game(Club home, Club away) {
        this.home = home;
        this.away = away;
        this.isFinish = false;
    }

    @Override
    public String toString() {
        return "host=" + home.getName() +
                ", guest=" + away.getName() +
                ", localDate=" + localDate + '\n';
    }
}

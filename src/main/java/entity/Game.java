package entity;

import base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Game extends BaseEntity {

    @OneToOne
    private Club host;
    @OneToOne
    private Club guest;

}

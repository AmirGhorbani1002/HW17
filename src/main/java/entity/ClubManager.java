package entity;

import entity.supers.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClubManager extends Person {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Club club;

    public ClubManager(String firstname, String lastname, String nationalCode) {
        super(firstname, lastname, nationalCode);
    }
}

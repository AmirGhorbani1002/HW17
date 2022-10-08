package entity.supers;

import base.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstname;
    private String lastname;
    private String nationalCode;

    public Person(String firstname, String lastname, String nationalCode, Double value) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
    }
}

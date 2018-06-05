package sieduszewski.lukasz.com.schooljournal.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
public abstract class Person {

    @NotNull
    private String surname;

    @NotNull
    private String name;

    @Id
    private String personalId;

    public Person() {
    }

    public Person(String surname, String name, String personalId) {
        this.surname = surname;
        this.name = name;
        this.personalId = personalId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}

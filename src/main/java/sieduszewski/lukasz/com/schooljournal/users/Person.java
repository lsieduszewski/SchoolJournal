package sieduszewski.lukasz.com.schooljournal.users;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
public abstract class Person {

    @NotNull
    private String surname;

    @NotNull
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personalId;

    public Person() {
    }

    public Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public long getPersonalId() {
        return personalId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalId(long personalId) {
        this.personalId = personalId;
    }
}

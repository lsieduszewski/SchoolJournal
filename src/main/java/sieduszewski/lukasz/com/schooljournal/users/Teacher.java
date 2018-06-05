package sieduszewski.lukasz.com.schooljournal.users;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {


    public Teacher() {

    }

    public Teacher(String surname, String name, String personalId) {
        super(surname, name, personalId);
    }
}

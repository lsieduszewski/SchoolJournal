package sieduszewski.lukasz.com.schooljournal.users;

import sieduszewski.lukasz.com.schooljournal.classsubject.ClassSubject;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher extends Person {

    @OneToMany(mappedBy = "subjectTeacher")
    private List<ClassSubject> classSubjects;


    public Teacher() {

    }

    public Teacher(String surname, String name) {
        super(surname, name);
    }
}

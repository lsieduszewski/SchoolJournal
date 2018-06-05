package sieduszewski.lukasz.com.schooljournal.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sieduszewski.lukasz.com.schooljournal.marks.Mark;
import sieduszewski.lukasz.com.schooljournal.schooljournal.SchoolJournal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolJournal_id")
    private SchoolJournal schoolJournal;

    @JsonIgnore
    public List<Mark> getStudentMarks() {

        return schoolJournal.getMarks();
    }

    public Student() {
    }

    public Student(String surname, String name, String personalId) {
        super(surname, name, personalId);
        schoolJournal = new SchoolJournal(new ArrayList<>());
    }

    public SchoolJournal getSchoolJournal() {
        return schoolJournal;
    }


}

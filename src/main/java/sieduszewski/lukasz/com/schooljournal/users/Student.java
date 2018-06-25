package sieduszewski.lukasz.com.schooljournal.users;

import sieduszewski.lukasz.com.schooljournal.classjournal.ClassJournal;
import sieduszewski.lukasz.com.schooljournal.marks.Mark;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private ClassJournal studentClass;

    private List<Mark> marks;


    public void addMark(Mark mark) {
        if (mark.isInRange())
            marks.add(mark);
    }

    public void changeMark(Mark oldMark, Mark newMark) {
        if (marks.contains(oldMark) && newMark.isInRange()) {
            marks.remove(oldMark);
            addMark(newMark);
        }

    }

    public ClassJournal getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(ClassJournal studentClass) {
        this.studentClass = studentClass;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public Student() {
    }

    public Student(String surname, String name, ClassJournal studentClass) {
        super(surname, name);
        this.studentClass = studentClass;
        this.marks = new ArrayList<>();
    }
}

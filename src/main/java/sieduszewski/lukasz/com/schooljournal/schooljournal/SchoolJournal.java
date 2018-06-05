package sieduszewski.lukasz.com.schooljournal.schooljournal;

import sieduszewski.lukasz.com.schooljournal.marks.Mark;
import sieduszewski.lukasz.com.schooljournal.users.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class SchoolJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "schoolJournal")
    private List<Student> studentList;

    @OneToMany
    private List<Mark> marks;

    public double getMarksWageSum(List<Mark> marks) {
        double wageSum = 0;
        for (Mark mark : marks) {
            wageSum += mark.getMarkWage();
        }
        return wageSum;
    }

    public double getSingleMarkWage(Mark mark) {
        double singleMarkWage = mark.getMarkWage() * mark.getMarkValue();
        return singleMarkWage;
    }

    public double getMarksAvgSum(List<Mark> marks) {
        double marksAvgSum = 0;
        for (Mark mark : marks) {
            marksAvgSum += getSingleMarkWage(mark);
        }
        return marksAvgSum;
    }

    public double getAvgMarks() {
        double avgMark = getMarksAvgSum(marks) / getMarksWageSum(marks);
        System.out.println(avgMark);
        return avgMark;
    }

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

    public List<Mark> getMarks() {
        return marks;
    }

    public SchoolJournal() {
    }

    public SchoolJournal(List<Mark> marks) {
        this.marks = marks;
    }

}

package sieduszewski.lukasz.com.schooljournal.marks;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double markWage;
    private double markValue;

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

    public double getAvgMarks(List<Mark> marks) {
        double avgMark = getMarksAvgSum(marks) / getMarksWageSum(marks);
        System.out.println(avgMark);
        return avgMark;
    }

    public boolean isInRange() {
        if (markValue > 6.0 || markValue < 1.0) {
            throw new IllegalArgumentException("Ocena nie mieści się w zasięgu");
        } else {
            return true;
        }
    }

    public Mark() {
    }

    public Mark(double markWage, double markValue) {
        this.markWage = markWage;
        this.markValue = markValue;
    }

    public double getMarkWage() {
        return markWage;
    }

    public double getMarkValue() {
        return markValue;
    }


}

package sieduszewski.lukasz.com.schooljournal.marks;

import sieduszewski.lukasz.com.schooljournal.schooljournal.SchoolJournal;

import javax.persistence.*;

@Entity
public abstract class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private SchoolJournal schoolJournal;

    private double markWage;
    private double markValue;


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

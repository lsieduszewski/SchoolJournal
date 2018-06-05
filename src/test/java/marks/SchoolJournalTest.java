package marks;

import org.junit.Assert;
import org.junit.Before;
import sieduszewski.lukasz.com.schooljournal.marks.Mark;
import sieduszewski.lukasz.com.schooljournal.marks.QuizMark;
import sieduszewski.lukasz.com.schooljournal.marks.TestMark;
import sieduszewski.lukasz.com.schooljournal.schooljournal.SchoolJournal;
import sieduszewski.lukasz.com.schooljournal.users.Student;

import java.util.ArrayList;

public class SchoolJournalTest {

    private static SchoolJournal schoolJournal;

    @Before
    public void setUpBeforeTest() {
        schoolJournal = new SchoolJournal(new ArrayList<>());

    }

    @org.junit.Test
    public void checkCorrectMark() {

        Mark mark = new QuizMark(4.0);
        Assert.assertTrue(mark.isInRange());
        Mark mark2 = new TestMark(4.0);
        Assert.assertTrue(mark2.isInRange());
        Mark mark3 = new QuizMark(5.0);
        Assert.assertTrue(mark3.isInRange());
    }


    @org.junit.Test(expected = IllegalArgumentException.class)
    public void checkToSmallMark() throws IllegalArgumentException {

        Mark mark = new QuizMark(0.99);
        mark.isInRange();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void checkToLargeMark() {

        Mark mark = new QuizMark(6.01);
        mark.isInRange();
    }


    @org.junit.Test
    public void shouldSayThatIsThreeElements() {  //testing addMark method

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(4.0);
        schoolJournal.addMark(mark2);
        Mark mark3 = new QuizMark(5.0);
        schoolJournal.addMark(mark3);

        Assert.assertEquals(3, schoolJournal.getMarks().size());
    }

    @org.junit.Test
    public void shouldSayThatIsEqual() { //testing getAvgMarks method

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(4.0);
        schoolJournal.addMark(mark2);
        Mark mark3 = new QuizMark(5.0);
        schoolJournal.addMark(mark3);

        Assert.assertEquals(4.30, schoolJournal.getAvgMarks(), 0.00);
    }

    @org.junit.Test
    public void shouldRemoveOldMarkAndAddNew() { //testing removeMark method

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(4.0);
        schoolJournal.addMark(mark2);
        Mark mark3 = new QuizMark(5.0);

        schoolJournal.changeMark(mark2, mark3);

        Assert.assertEquals(2, schoolJournal.getMarks().size());
        Assert.assertTrue(schoolJournal.getMarks().contains(mark3));
        Assert.assertFalse(schoolJournal.getMarks().contains(mark2));
    }

    @org.junit.Test
    public void shouldNotRemoveOldMarkAndDontAddNew() { //testing removeMark method

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(4.0);
        schoolJournal.addMark(mark2);
        Mark mark3 = new QuizMark(5.0);

        schoolJournal.changeMark(mark3, mark2);

        Assert.assertEquals(2, schoolJournal.getMarks().size());
        Assert.assertTrue(schoolJournal.getMarks().contains(mark2));
        Assert.assertFalse(schoolJournal.getMarks().contains(mark3));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void shouldNotRemoveOldMarkAndThrowException() throws IllegalArgumentException { //testing removeMark method

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(7.0);
        schoolJournal.addMark(mark2);

        schoolJournal.changeMark(mark, mark2);
    }

    @org.junit.Test
    public void shouldCreateNewStudent() {

        Student student = new Student("Kowalski", "Adam", "1237126");

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(4.0);
        schoolJournal.addMark(mark2);

        student.getSchoolJournal().addMark(mark);
        student.getSchoolJournal().addMark(mark2);

        Assert.assertEquals(2, student.getStudentMarks().size());
    }

    @org.junit.Test
    public void shouldNotCreateNewStudent() {

        Student student = new Student("Kowalski", "Adam", "1237126");

        Mark mark = new QuizMark(4.0);
        schoolJournal.addMark(mark);
        Mark mark2 = new TestMark(4.0);
        schoolJournal.addMark(mark2);

        student.getSchoolJournal().addMark(mark);
        student.getSchoolJournal().addMark(mark2);

        Assert.assertEquals(2, student.getStudentMarks().size());
    }


}

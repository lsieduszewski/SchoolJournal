package sieduszewski.lukasz.com.schooljournal.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sieduszewski.lukasz.com.schooljournal.marks.ActivityMark;
import sieduszewski.lukasz.com.schooljournal.marks.Mark;
import sieduszewski.lukasz.com.schooljournal.marks.QuizMark;
import sieduszewski.lukasz.com.schooljournal.marks.TestMark;

import static org.junit.Assert.*;

public class StudentTest {

    private static Student student;

    @Before
    public void setUpBeforeTest() {
        student = new Student("Kowalski", "Adam", null);
    }

    @Test
    public void shouldSayThatIsThreeMarks() {

        Mark mark1 = new QuizMark(3.0);
        Mark mark2 = new TestMark(2.5);
        Mark mark3 = new ActivityMark(4);

        student.addMark(mark1);
        student.addMark(mark2);
        student.addMark(mark3);

        Assert.assertEquals(3, student.getMarks().size());
    }

    @Test
    public void shouldRemoveOldMarkAndAddNew() {

        Mark oldMark = new QuizMark(3.0);
        student.addMark(oldMark);
        Mark newMark = new ActivityMark(4.0);
        student.changeMark(oldMark, newMark);

        assertEquals(1, student.getMarks().size());
        assertTrue(student.getMarks().contains(newMark));
        assertFalse(student.getMarks().contains(oldMark));
    }

    @Test
    public void shouldNotRemoveAndShouldNotAddNewMark() {

        Mark oldMark = new QuizMark(3.0);
        student.addMark(oldMark);
        Mark newMark = new ActivityMark(4.0);
        Mark missMark = new QuizMark(3.0);

        student.changeMark(missMark, newMark);

        assertEquals(1, student.getMarks().size());
        assertTrue(student.getMarks().contains(oldMark));
        assertFalse(student.getMarks().contains(newMark));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotRemoveOldMarkAndThrowException() throws IllegalArgumentException {

        Mark mark = new QuizMark(4.0);
        student.addMark(mark);
        Mark mark2 = new TestMark(7.0);
        student.addMark(mark2);

    }


}



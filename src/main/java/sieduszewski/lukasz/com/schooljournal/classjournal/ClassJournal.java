package sieduszewski.lukasz.com.schooljournal.classjournal;

import sieduszewski.lukasz.com.schooljournal.classsubject.ClassSubject;
import sieduszewski.lukasz.com.schooljournal.users.Student;
import sieduszewski.lukasz.com.schooljournal.users.Teacher;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ClassJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String className;

    private List<ClassSubject> subjectList;

    @OneToMany(mappedBy = "studentClass")
    private List<Student> studentList;

    private Teacher mainTeacher;

    public long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public List<ClassSubject> getSubjectList() {
        return subjectList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public ClassJournal() {
    }

    public ClassJournal(String className, Teacher mainTeacher) {
        this.className = className;
        this.mainTeacher = mainTeacher;
        this.studentList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
    }
}

package sieduszewski.lukasz.com.schooljournal.classsubject;

import sieduszewski.lukasz.com.schooljournal.users.Teacher;

import javax.persistence.*;

public class ClassSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String subjectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher subjectTeacher;



}



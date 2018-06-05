package sieduszewski.lukasz.com.repository.user;

import sieduszewski.lukasz.com.schooljournal.users.Student;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository<student extends Student> extends UserBaseRepository<Student> {


    @Override
    Student findByPersonalId(String personalId);
}

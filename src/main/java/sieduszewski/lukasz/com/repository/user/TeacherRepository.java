package sieduszewski.lukasz.com.repository.user;

import sieduszewski.lukasz.com.schooljournal.users.Teacher;

import javax.transaction.Transactional;

@Transactional
public interface TeacherRepository extends UserBaseRepository<Teacher> {
}

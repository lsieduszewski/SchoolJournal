package sieduszewski.lukasz.com.repository.user;

import sieduszewski.lukasz.com.schooljournal.users.Person;

import javax.transaction.Transactional;

@Transactional
public interface PersonRepository extends UserBaseRepository<Person> {
}

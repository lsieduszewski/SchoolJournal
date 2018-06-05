package sieduszewski.lukasz.com.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import sieduszewski.lukasz.com.schooljournal.users.Person;

@NoRepositoryBean
public interface UserBaseRepository<person extends Person> extends CrudRepository<person, Long> {

    person findByPersonalId(String personalId);

}

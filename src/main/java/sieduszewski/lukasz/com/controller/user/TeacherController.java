package sieduszewski.lukasz.com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.com.repository.user.TeacherRepository;
import sieduszewski.lukasz.com.schooljournal.users.Person;
import sieduszewski.lukasz.com.schooljournal.users.Teacher;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/teacher")
public class TeacherController{

    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping("/addTeacher")
    public Person person(@RequestBody Teacher teacher) {

        teacherRepository.save(teacher);

        return teacher;
    }


}


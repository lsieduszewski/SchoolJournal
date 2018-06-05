package sieduszewski.lukasz.com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.com.repository.user.StudentRepository;
import sieduszewski.lukasz.com.schooljournal.users.Person;
import sieduszewski.lukasz.com.schooljournal.users.Student;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/users")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/addStudent")
    public Person person(@RequestBody Student student) {

        studentRepository.save(student);

        return student;
    }

    @RequestMapping("/deleteStudent")
    public boolean deleteStudentByPersonalId(@RequestBody String personalId) {

        Person studentToDelete = studentRepository.findByPersonalId(personalId);

        if (studentToDelete == null) {
            return false;
        } else {
            studentRepository.delete(studentToDelete);
            return true;
        }

    }


}

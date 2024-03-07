package Lab1.demo;

import Lab1.demo.model.Person;
import Lab1.demo.repc.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonRepo personRepo;

    @Autowired
    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    // Отримати всіх осіб
    @GetMapping
    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

    // Отримати особу за ідентифікатором
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepo.findById(id).orElse(null);
    }

    // Зберегти нову особу
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person newPerson) {
        return personRepo.save(newPerson);
    }

    // Оновити існуючу особу
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepo.findById(id)
                .map(person -> {
                    person.setTitle(updatedPerson.getTitle());
                    person.setAuthor(updatedPerson.getAuthor());
                    person.setYear(updatedPerson.getYear());
                    person.setPublisher(updatedPerson.getPublisher());
                    person.setPageCount(updatedPerson.getPageCount());
                    return personRepo.save(person);
                })
                .orElse(null);
    }

    // Видалити особу за ідентифікатором
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepo.deleteById(id);
    }
}

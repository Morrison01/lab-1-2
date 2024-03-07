package Lab1.demo.service;

import Lab1.demo.model.Person;
import Lab1.demo.repc.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepo.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepo.save(person);
    }

    public Optional<Person> updatePerson(Long id, Person updatedPerson) {
        return personRepo.findById(id)
                .map(person -> {
                    person.setTitle(updatedPerson.getTitle());
                    person.setAuthor(updatedPerson.getAuthor());
                    person.setYear(updatedPerson.getYear());
                    person.setPublisher(updatedPerson.getPublisher());
                    person.setPageCount(updatedPerson.getPageCount());
                    return personRepo.save(person);
                });
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}

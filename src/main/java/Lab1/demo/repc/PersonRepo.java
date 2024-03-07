package Lab1.demo.repc;

import Lab1.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findByTitle(String title);
    List<Person> findByAuthor(String author);
    List<Person> findByYear(int year);
    List<Person> findByPublisher(String publisher);

    List<Person> findByPageCountLessThan(int pageCount);

    List<Person> findByPageCountGreaterThan(int pageCount);
}

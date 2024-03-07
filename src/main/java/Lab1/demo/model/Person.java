package Lab1.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    private int id;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private int pageCount;

    // Гетери генеруються автоматично за допомогою Lombok.
}

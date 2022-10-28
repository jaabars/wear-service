package kg.itschoolmegacom.wearservice.models.entities;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  int publishedYear;

  @ManyToOne
  @JoinColumn(name = "author_id")
  Author author;
}

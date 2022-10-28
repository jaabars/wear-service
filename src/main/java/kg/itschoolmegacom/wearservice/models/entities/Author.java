package kg.itschoolmegacom.wearservice.models.entities;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
}

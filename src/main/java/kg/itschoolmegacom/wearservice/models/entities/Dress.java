package kg.itschoolmegacom.wearservice.models.entities;

import kg.itschoolmegacom.wearservice.models.enums.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "dresses")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String size;
  @Enumerated(value = EnumType.ORDINAL)
  Gender gender;
  double price;
  boolean available;
  String color;
  String category;

  @Transient
  double amount;
}

package kg.itschoolmegacom.wearservice.models.dtos.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DressCalcRequest {
  Long id;
  int quantity;
}

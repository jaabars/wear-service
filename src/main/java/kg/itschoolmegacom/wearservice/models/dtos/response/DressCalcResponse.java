package kg.itschoolmegacom.wearservice.models.dtos.response;

import kg.itschoolmegacom.wearservice.models.entities.Dress;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DressCalcResponse {
   List<Dress> dress;
   double sum;
}

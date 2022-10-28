package kg.itschoolmegacom.wearservice.services;

import kg.itschoolmegacom.wearservice.models.dtos.request.DressCalcRequest;
import kg.itschoolmegacom.wearservice.models.dtos.response.DressCalcResponse;
import kg.itschoolmegacom.wearservice.models.entities.Dress;

import java.util.List;

public interface DressService {
  Dress save(Dress dress);

  List<Dress> getAllByAvailability(boolean available);

  DressCalcResponse calculate(List<DressCalcRequest> dressCalcRequestList);
}

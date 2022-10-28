package kg.itschoolmegacom.wearservice.services.impl;

import kg.itschoolmegacom.wearservice.models.dtos.request.DressCalcRequest;
import kg.itschoolmegacom.wearservice.models.dtos.response.DressCalcResponse;
import kg.itschoolmegacom.wearservice.models.entities.Dress;
import kg.itschoolmegacom.wearservice.repository.DressRepo;
import kg.itschoolmegacom.wearservice.services.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DressServiceImpl implements DressService {

  private final  DressRepo dressRepo;

  @Autowired
  public DressServiceImpl(DressRepo dressRepo) {
    this.dressRepo = dressRepo;
  }

  @Override
  public Dress save(Dress dress) {
    return dressRepo.save(dress);
  }

  @Override
  public List<Dress> getAllByAvailability(boolean available) {
    return dressRepo.findAllByAvailableIs(available);
  }

  @Override
  public DressCalcResponse calculate(List<DressCalcRequest> dressCalcRequestList) {
    List<Dress> dressList = dressRepo.findAllByAvailableIs(true);
    DressCalcResponse dressCalcResponse = new DressCalcResponse();

    List<Dress> userDresses = new ArrayList<>();

    dressCalcRequestList.stream().forEach(dressCalcRequest -> {

      Optional<Dress> wear = dressList.stream()
          .filter(dress -> dress.getId().equals(dressCalcRequest.getId())).findFirst();

      if (wear.isPresent()) {
        Dress dress = wear.get();
        dress.setAmount(dressCalcRequest.getQuantity() * wear.get().getPrice());

        userDresses.add(dress);
      }
    });

    double sum = userDresses.stream()
        .mapToDouble(Dress::getAmount)
        .sum();

    dressCalcResponse.setSum(sum);
    dressCalcResponse.setDress(dressList);

    return dressCalcResponse;
  }
}

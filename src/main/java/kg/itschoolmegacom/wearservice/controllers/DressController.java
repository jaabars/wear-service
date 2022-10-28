package kg.itschoolmegacom.wearservice.controllers;

import kg.itschoolmegacom.wearservice.models.dtos.request.DressCalcRequest;
import kg.itschoolmegacom.wearservice.models.dtos.response.DressCalcResponse;
import kg.itschoolmegacom.wearservice.models.entities.Dress;
import kg.itschoolmegacom.wearservice.services.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dress")
public class DressController {

  private final DressService dressService;

  @Autowired
  public DressController(DressService dressService) {
    this.dressService = dressService;
  }

  @PostMapping("/save")
  public Dress save(@RequestBody Dress dress){
    return dressService.save(dress);
  }

  @GetMapping("/list/{available}")
  public List<Dress> listDresses(@PathVariable boolean available){
    return dressService.getAllByAvailability(available);
  }

  @PostMapping("/calculate")
  public DressCalcResponse calculateWears(@RequestBody List<DressCalcRequest> dressCalcRequestList){
    return dressService.calculate(dressCalcRequestList);
  }
}

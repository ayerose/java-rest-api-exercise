package com.cbfacademy.restapiexercise.ious;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ious")
public class IOUController {

  private IOUService iouService;

  public IOUController(IOUService iouService) {
    this.iouService = iouService;
  }
  
  @GetMapping(produces = "application/json")
  public List<IOU> getAllIOUs() {
    return iouService.getAllIOUs();
  }

  @PostMapping(produces = "application/json")
  public IOU createIou(@RequestBody IOU iou) {
    return iouService.createIOU(iou);
  }
}






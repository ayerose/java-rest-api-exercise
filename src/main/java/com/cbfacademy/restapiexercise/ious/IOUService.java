package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class IOUService {
  
  private IOURepository iouRepository;

  public IOUService(IOURepository iouRepository) {
    this.iouRepository = iouRepository;
  }

  public List<IOU> getAllIOUs() {
    return this.iouRepository.findAll();
  }

public IOU getIOU(UUID id) {
        return iouRepository.findById(id).orElseThrow(() -> new NoSuchElementException("IOU not found with id: " + id));
    }

   public IOU createIOU(IOU iou) {
        if (iou.getBorrower() == null || iou.getLender() == null || iou.getAmount() == null || iou.getDateTime() == null) {
            throw new IllegalArgumentException("All fields are required to create an IOU");
        }
        return iouRepository.save(iou);
    }

 public IOU updateIOU(UUID id, IOU updatedIOU) {
        IOU existingIOU = getIOU(id); // This will throw NoSuchElementException if not found
        existingIOU.setBorrower(updatedIOU.getBorrower());
        existingIOU.setLender(updatedIOU.getLender());
        existingIOU.setAmount(updatedIOU.getAmount());
        existingIOU.setDateTime(updatedIOU.getDateTime());
        return iouRepository.save(existingIOU);
    }
    

  public void deleteIOU(UUID id) {
    this.iouRepository.delete(getIOU(id));
  }

}
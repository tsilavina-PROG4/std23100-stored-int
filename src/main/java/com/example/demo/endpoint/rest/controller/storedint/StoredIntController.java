package com.example.demo.endpoint.rest.controller.storedint;

import com.example.demo.service.storedint.StoredIntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {

  @Autowired private StoredIntService storedIntService;

  @GetMapping("/stored-int")
  public ResponseEntity<Integer> getStoredInt() {
    return storedIntService.getStoredInt();
  }
}

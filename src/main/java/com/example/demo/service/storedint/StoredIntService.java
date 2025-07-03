package com.example.demo.service.storedint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {
  private static final String FILE_PATH = "/tmp/stored-int.txt"; // Disque temporaire Lambda

  public ResponseEntity<Integer> storedInt() {
    try {
      Path path = Paths.get(FILE_PATH);
      int number;

      if (Files.exists(path)) {
        String content = Files.readString(path);
        number = Integer.parseInt(content.trim());
      } else {
        number = new Random().nextInt(1000);
        Files.writeString(path, String.valueOf(number));
      }

      return ResponseEntity.ok(number);

    } catch (IOException | NumberFormatException e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}

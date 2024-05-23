package com.testingf.testing.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class WebReadService {

  public String readfile(String filename) throws IOException {
    StringBuilder content = new StringBuilder();
    try (
        InputStream inputStream = getClass().getResourceAsStream("/" + filename + ".txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }

    }
    return content.toString();
  }
}

package com.testingf.testing.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

  private final WebReadService webReadService;

  public WebController(WebReadService webReadService) {
    this.webReadService = webReadService;
  }

  @GetMapping("")
  public String getHomePage() {
    return "index";
  }

  @PostMapping("/read")
  public String submitForm(@RequestParam("item") String item, RedirectAttributes redirectAttributes)
      throws IOException {
    String response = webReadService.readfile(item);
    redirectAttributes.addFlashAttribute("response", response);
    return "redirect:/";
  }

}

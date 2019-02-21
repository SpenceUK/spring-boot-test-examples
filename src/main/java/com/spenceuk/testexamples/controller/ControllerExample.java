package com.spenceuk.testexamples.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class ControllerExample {

  @GetMapping(path = "/hello")
  public Greeting helloWorld() {
    Greeting myGreeting = new Greeting();
    myGreeting.setLanguage("Spanish");
    myGreeting.setMessage("Hola");
    myGreeting.setLetters(Arrays.asList('h','o','l','a'));
    return myGreeting;
  }
}

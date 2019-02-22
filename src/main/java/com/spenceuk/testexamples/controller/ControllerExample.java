package com.spenceuk.testexamples.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ControllerExample {

  /**
   * Hit this endpoint at "https://"
   */
  @GetMapping(path = "/hello")
  public Greeting helloWorld() {
    Greeting myGreeting = new Greeting();
    myGreeting.setLanguage("Spanish");
    myGreeting.setMessage("Hola");
    myGreeting.setLetters(Arrays.asList('h','o','l','a'));
    return myGreeting;
  }

  @GetMapping(path = "/goodbye")
  public ResponseEntity<Greeting> helloWithResponseEntity() {
    Greeting myGreeting = new Greeting();
    myGreeting.setLanguage("French");
    myGreeting.setMessage("Bonjour");
    myGreeting.setLetters(Arrays.asList('b','o','n','j','o','u','r'));
    return ResponseEntity.status(HttpStatus.OK)
        .header("X-Custom", "custom-message")
        .body(myGreeting);
  }

}

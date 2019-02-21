package com.spenceuk.testexamples.controller;

import java.util.List;

import lombok.Data;

@Data
public class Greeting {
  String language;
  String message;
  List<Character> letters;
}
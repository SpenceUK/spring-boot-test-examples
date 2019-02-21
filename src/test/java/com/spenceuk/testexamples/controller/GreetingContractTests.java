package com.spenceuk.testexamples.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GreetingContractTests {

  private ControllerExample controller;
  private MockMvc mockServer;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    controller = new ControllerExample();

    mockServer = MockMvcBuilders
            .standaloneSetup(controller)
            .build();
  }

  @Test
  public void headersTest() throws Exception {
    mockServer.perform(
        MockMvcRequestBuilders.get("/api/v1/hello"))
    .andDo(MockMvcResultHandlers.print())
    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void jsonContractTest() throws Exception {
    mockServer.perform(
        MockMvcRequestBuilders.get("/api/v1/hello"))
    .andDo(MockMvcResultHandlers.print())
    .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
    .andExpect(MockMvcResultMatchers.jsonPath("$.language").exists())
    .andExpect(MockMvcResultMatchers.jsonPath("$.language").isString())
    .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists())
    .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
    .andExpect(MockMvcResultMatchers.jsonPath("$.letters").exists())
    .andExpect(MockMvcResultMatchers.jsonPath("$.letters").isArray())
    .andExpect(MockMvcResultMatchers.jsonPath("$.letters[0]").value("h"))
    .andExpect(MockMvcResultMatchers.jsonPath("$.letters[3]").value("a"));
  }
}
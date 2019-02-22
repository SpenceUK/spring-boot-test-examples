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

  /**
   * This test will perform a request to the mock server which will
   * act like a real server and only hand it off to the controller if
   * it matches a route for method, content type etc.
   * The logic within the controller will then run and we can assert on the
   * response from the controller.
   *
   * If there is business logic within the controller method you should refactor this
   * out into a service layer or component so you can properly unit test this logic in
   * isolation and can be mocked within your controller test. The controller tests should
   * be concerned only with the request mapping to the controller method/route successfully
   * and the response object returned. Generally the serialization and deserialization of
   * the request and response objects.
   */
  @Test
  public void helloStatusOkTest() throws Exception {
    mockServer.perform(
        MockMvcRequestBuilders.get("/api/v1/hello"))
        /**
         * This will print to the terminal the exchange.
         * this is useful for debugging but you should
         * leave it out if not debugging as it is overly verbose.
         */
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

  @Test
  public void goodbyeStatusOkTest() throws Exception {
    mockServer.perform(
        MockMvcRequestBuilders.get("/api/v1/goodbye"))
    .andDo(MockMvcResultHandlers.print())
    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void goodbyeHeadersTest() throws Exception {
    mockServer.perform(
        MockMvcRequestBuilders.get("/api/v1/goodbye"))
    .andExpect(MockMvcResultMatchers.header().exists("X-Custom"))
    .andExpect(MockMvcResultMatchers.header().string("X-Custom", "custom-message"));
  }

}

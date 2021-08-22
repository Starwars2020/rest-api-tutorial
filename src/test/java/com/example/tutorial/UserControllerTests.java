package com.example.tutorial;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.tutorial.controller.UserController;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getAllUsersAPI() throws Exception {
    this.mvc.perform(get("/demo/all")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("")));
  }
  
  //@Test
  //public void addNewUserAPI() throws Exception {
  //  mvc.perform(get("/demo/add", "John","example@example.com"))
  //          .andExpect(status().isOk())
  //          .andExpect(jsonPath("$.message").value(""));
  //}
}
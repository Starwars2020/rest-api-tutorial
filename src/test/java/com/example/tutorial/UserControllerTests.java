package com.example.tutorial;

import com.example.tutorial.controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void addNewUser() throws Exception {
    String name = "John";
    String email = "example@example.com";
  
    mvc.perform(get("/demo/add"))
            .andExpect(status().isOk())
            .andExpect(content().string(name))
            .andExpect(content().string(email));
  }
  
  //@Test
  //public void getAllUsers() throws Exception {
  //  String name = "John";
  //  String email = "example@example.com";
  //
  //  mvc.perform(get("/demo/all")
  //  		.param("name", name)
  //  		.param("amount", String.valueOf(amount)))
  //          .andExpect(status().isOk())
  //          .andExpect(jsonPath("$.name", is(name)))
  //          .andExpect(jsonPath("$.amount", is(email)));
  //}
}
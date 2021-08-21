package com.example.tutorial;

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
@WebMvcTest(controllers = HelloController.class)
public class UserControllerTests {

	@Autowired
	private MockMvc mvc;

  @Test
  public void user_to_return() throws Exception {
    String user = "demo";
  
    mvc.perform(get("/demo"))
            .andExpect(status().isOk())
            .andExpect(content().string(user));
  }
  
  //@Test
  //public void userAll_to_return() throws Exception {
  //  String name = "demo";
  //  int amount = 1000;
  //
  //  mvc.perform(get("/demo/all")
  //  		.param("name", name)
  //  		.param("amount", String.valueOf(amount)))
  //          .andExpect(status().isOk())
  //          .andExpect(jsonPath("$.name", is(name)))
  //          .andExpect(jsonPath("$.amount", is(amount)));
  //}
}
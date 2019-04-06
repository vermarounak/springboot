package com.example.bestever.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.bestever.controller.GreetingController.GET_GREETING;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GreetingControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        GreetingController greetingController = new GreetingController();
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
    }

    @Test
    void greet() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(GET_GREETING)
                .param("name", "Rounak"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1,'name': 'Hello, Rounak'}"));
    }

    @Test
    void greet_withoutRequestParameter() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(GET_GREETING))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1,'name': 'Hello, Spring'}"));
    }
}
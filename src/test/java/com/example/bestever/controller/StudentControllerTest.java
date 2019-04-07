package com.example.bestever.controller;

import com.example.bestever.entity.Student;
import com.example.bestever.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/find")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

    @Test
    void findById_notPresent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/find")
                .param("id", "101"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("")));
    }

    @Test
    void save() throws Exception {
        Student student = new Student("Test", "TestPassport");

        mockMvc.perform(MockMvcRequestBuilders.post("/students/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.asString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void getAll() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/students/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
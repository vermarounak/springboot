package com.example.bestever.util;

import com.example.bestever.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

class JsonUtilsTest {

    @Test
    void asString() throws JsonProcessingException {
        Student student = new Student("Test", "TestPassport");

        final String asString = JsonUtils.asString(student);

        assertThat("parsed String is ", asString, containsString("Test"));
    }
}
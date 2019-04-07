package com.example.bestever.repository;

import com.example.bestever.entity.SortNumber;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SortNumberRepositoryTest {

    @Autowired
    private SortNumberRepository sortNumberRepository;

    @Test
    void save(){
        String unsortedNumbers = "2,4,3";
        SortNumber sortNumber = new SortNumber(unsortedNumbers);
        sortNumber.setTimeTakenInMilliSeconds(25);

        sortNumberRepository.save(sortNumber);

        assertThat("saved sortNumber has id", sortNumber.getId(), is(notNullValue()));
    }
}
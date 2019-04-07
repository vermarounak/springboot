package com.example.bestever.controller;

import com.example.bestever.entity.SortNumber;
import com.example.bestever.service.SortNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/sortNumber")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SortNumberController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final SortNumberService sortNumberService;

    @Autowired
    public SortNumberController(SortNumberService sortNumberService) {
        this.sortNumberService = sortNumberService;
    }

    @PostMapping("/sort")
    public SortNumber sort(@RequestBody SortNumber sortNumber) {
        Instant startTime = Instant.now();

        final SortNumber savedSortNumber = sortNumberService.sortAndSave(sortNumber);

        LOG.info("Time taken by complete operation is {}ms",
                Duration.between(startTime, Instant.now()).toMillis());

        return savedSortNumber;
    }
}

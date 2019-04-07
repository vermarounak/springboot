package com.example.bestever.service;

import com.example.bestever.entity.SortNumber;

import java.util.List;

public interface SortNumberService {

    SortNumber sortAndSave(SortNumber sortNumber);

    List<SortNumber> findAll();
}

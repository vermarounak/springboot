package com.example.bestever.service;

import com.example.bestever.entity.SortNumber;
import com.example.bestever.repository.SortNumberRepository;
import com.example.bestever.util.SortingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class SortNumberServiceImpl implements SortNumberService {

    private final SortNumberRepository sortNumberRepository;

    @Autowired
    public SortNumberServiceImpl(SortNumberRepository sortNumberRepository) {
        this.sortNumberRepository = sortNumberRepository;
    }

    @Override
    public SortNumber sortAndSave(SortNumber sortNumber) {
        Instant startTime = Instant.now();
        String sortedNumbers = SortingUtils.sort(sortNumber.getUnsortedNumbers());
        sortNumber.setSortedNumbers(sortedNumbers);
        sortNumber.setTimeTakenInMilliSeconds(
                Duration.between(startTime, Instant.now()).toMillis());

        return sortNumberRepository.save(sortNumber);
    }

    @Override
    public List<SortNumber> findAll() {
        return sortNumberRepository.findAll(Sort.by(Sort.Direction.DESC, "creationTime"));
    }
}

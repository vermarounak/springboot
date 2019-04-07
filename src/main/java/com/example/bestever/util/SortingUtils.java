package com.example.bestever.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SortingUtils.class);

    // \s*,\s*
    private static final String SPLIT_PATTERN_REGEX = ", ";

    public static String sort(String unsorted) {
        Instant startTime = Instant.now();

        Pattern pattern = Pattern.compile(SPLIT_PATTERN_REGEX);
        List<Integer> list = pattern.splitAsStream(unsorted)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        final String sortedNumbers = bubbleSort(list.size(), list);

        LOG.info("Time taken by sort operation is {}ms",
                Duration.between(startTime, Instant.now()).toMillis());

        return sortedNumbers;
    }

    private static String bubbleSort(int totalElements,
                                     List<Integer> elements) {
        IntStream.range(0, totalElements - 1)
                .forEach(indexInFirstLoop ->
                        IntStream.range(0, totalElements - 1)
                                .filter(indexInSecondLoop -> elements.get(indexInSecondLoop) > elements.get(indexInSecondLoop + 1))
                                .forEach(index -> {
                                    int temp = elements.get(index);
                                    elements.set(index, elements.get(index + 1));
                                    elements.set(index + 1, temp);
                                }));

        return elements.toString();
    }

    private SortingUtils() {

    }
}

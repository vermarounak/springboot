package com.example.bestever.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tSortNumber")
public class SortNumber extends BaseEntity{

    private String unsortedNumbers;
    private String sortedNumbers;
    private long timeTakenInMilliSeconds;

    private SortNumber(){ }

    public SortNumber(String unsortedNumbers){
        this.unsortedNumbers = unsortedNumbers;
    }

    public String getUnsortedNumbers() {
        return unsortedNumbers;
    }

    public String getSortedNumbers() {
        return sortedNumbers;
    }

    public long getTimeTakenInMilliSeconds() {
        return timeTakenInMilliSeconds;
    }

    public void setSortedNumbers(String sortedNumbers) {
        this.sortedNumbers = sortedNumbers;
    }

    public void setTimeTakenInMilliSeconds(long timeTakenInMilliSeconds) {
        this.timeTakenInMilliSeconds = timeTakenInMilliSeconds;
    }
}

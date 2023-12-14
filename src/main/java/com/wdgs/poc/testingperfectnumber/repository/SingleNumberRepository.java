package com.wdgs.poc.testingperfectnumber.repository;

import com.wdgs.poc.testingperfectnumber.model.PerfectNumberOne;
import com.wdgs.poc.testingperfectnumber.model.PerfectNumbersTwo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SingleNumberRepository extends JpaRepository<PerfectNumberOne, Long> {

    public PerfectNumberOne findByNumberOne(Integer numberOne);
}

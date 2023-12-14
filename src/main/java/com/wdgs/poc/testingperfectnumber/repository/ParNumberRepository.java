package com.wdgs.poc.testingperfectnumber.repository;

import com.wdgs.poc.testingperfectnumber.model.PerfectNumbersTwo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParNumberRepository extends JpaRepository<PerfectNumbersTwo, Long> {

}

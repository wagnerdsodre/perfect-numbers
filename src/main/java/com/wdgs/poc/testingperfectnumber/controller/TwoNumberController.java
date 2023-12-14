package com.wdgs.poc.testingperfectnumber.controller;

import com.wdgs.poc.testingperfectnumber.repository.ParNumberRepository;
import com.wdgs.poc.testingperfectnumber.model.PerfectNumbersTwo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static com.wdgs.poc.testingperfectnumber.utils.PerfectNumber.searchPerfectNumber;

@Slf4j
@Controller
@RequestMapping(path = "/twonumber")
public class TwoNumberController {


    @Autowired
    private ParNumberRepository repository;

    @GetMapping
    public ModelAndView loadTemplate() {
        return new ModelAndView("option-two-numbers");

    }

    @PostMapping
    public ModelAndView PostNumber(@Valid PerfectNumbersTwo perfectNumber) {
        repository.deleteAll();
        repository.save(perfectNumber);
        ModelAndView mv = new ModelAndView("option-two-numbers");
        List<PerfectNumbersTwo> dataDB = repository.findAll().stream().toList();
        List<Integer> list = new ArrayList<>();

        for (int i = perfectNumber.getNumberOne(); i < perfectNumber.getNumberTwo(); i++) {
            list.add(searchPerfectNumber(i));
        }
        list.removeIf(p -> p == 0);
        mv.addObject("list", list);
        return mv;



    }


}

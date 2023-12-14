package com.wdgs.poc.testingperfectnumber.controller;

import com.wdgs.poc.testingperfectnumber.repository.SingleNumberRepository;
import com.wdgs.poc.testingperfectnumber.model.PerfectNumbersTwo;
import com.wdgs.poc.testingperfectnumber.model.PerfectNumberOne;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.wdgs.poc.testingperfectnumber.utils.PerfectNumber.searchPerfectNumber;

@Slf4j
@Controller
@RequestMapping(path = "/number")
public class OneNumberController {


    private final SingleNumberRepository repository;

    public OneNumberController(SingleNumberRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView loadTemplate() {
        return new ModelAndView("onenumber");

    }


    @PostMapping
    public ModelAndView PostNumberOne(@Valid Integer oneNumber) {
        ModelAndView mv = new ModelAndView("onenumber");

        try{
            repository.deleteAll();
            PerfectNumberOne one = new PerfectNumberOne();
            one.setNumberOne(oneNumber);
            repository.save(one);
            PerfectNumberOne number = repository.findByNumberOne(one.getNumberOne());
            Integer verifyPerfectnumber = searchPerfectNumber(number.getNumberOne());
            mv.addObject("oneNumber",
                    verifyPerfectnumber == 0 ? "The number "+oneNumber+" not is a perfect number" :
                            "Awesome!!! The number "+oneNumber+" is a perfect number"
            );

        }
        catch (Exception e){
            throw new IllegalArgumentException("Number invalid");
        }

        return mv;

    }




}

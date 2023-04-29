package com.groupProject.MvAcronymQuizz2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    public MainController(AcronymsRepository u) {
        repositoryAcronyms = u;

    }

    private AcronymsRepository repositoryAcronyms;


    @GetMapping("/home")
    public String home() {
        System.out.println("arrived at home page");
        return "home";
    }



    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @GetMapping(path = "/getAcronyms", consumes = "application/json", produces = "application/json")
    public String getAcronyms() {

        System.out.println("Hit getAcronyms API");


        List<Acronyms> allDbEntries = repositoryAcronyms.findAll();

        String result = "Acronyms -->";

        for(int i = 0; i < allDbEntries.stream().count(); i++) {
            Acronyms a = allDbEntries.get(i);
            if(a != null) {
                result = result + a.getAcronymName() + a.getAcronymMeaning() + ", ";
            }


        }


        return result;



//    AcronymsVm[] listOfAcronyms = new AcronymsVm[5];
//        listOfAcronyms[0] = new AcronymsVm(1, "MVP", "Minimum Viable Product");
//        listOfAcronyms[1] = new AcronymsVm(2, "ISA", "Individual Savings Account");
//        listOfAcronyms[2] = new AcronymsVm(3, "SIPP", "Self Invested Personal Pension");
//        listOfAcronyms[3] = new AcronymsVm(4, "KID", "Key Investor Document");
//        listOfAcronyms[4] = new AcronymsVm(5, "MAaD", "My Accounts and Dealing");
//
//
//        int randomIndexFromArray = new Random().nextInt(listOfAcronyms.length);
//        System.out.println(randomIndexFromArray);
//        System.out.println("What does" + " " + listOfAcronyms[randomIndexFromArray].acronym + " " + "stand for?");
//
//        return listOfAcronyms;

    }





}

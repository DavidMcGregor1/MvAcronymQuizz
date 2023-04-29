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

    }


    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(path = "/addAcronym", consumes = "application/json", produces = "application/json")
    public AcronymsVm addAcronym(@RequestBody AcronymsVm submittedAcronym) {
        System.out.println("Add Acronym API Called");

        Acronyms newDataBaseAcronym = new Acronyms();
        newDataBaseAcronym.setAcronymName(submittedAcronym.acronym);
        newDataBaseAcronym.setAcronymMeaning(submittedAcronym.meaning);

        repositoryAcronyms.save(newDataBaseAcronym);

        return submittedAcronym;
    }





}

package com.groupProject.MvAcronymQuizz2;

import com.groupProject.MvAcronymQuizz2.*;
import com.groupProject.MvAcronymQuizz2.Acronyms;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.util.*;

@Controller
public class MainController {


    @GetMapping("/home")
    public String home() {
        System.out.println("arrived at home page");
        return "home";
    }



    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @GetMapping(path = "/getAcronyms", consumes = "application/json", produces = "application/json")
    public Acronyms[] getAcronyms() {

        System.out.println("Before Array");

    Acronyms[] listOfAcronyms = new Acronyms[10];
        listOfAcronyms[0] = new Acronyms(1, "MVP", "Minimum Viable Product");
        listOfAcronyms[1] = new Acronyms(2, "ISA", "Individual Savings Account");
        listOfAcronyms[2] = new Acronyms(3, "SIPP", "Self Invested Personal Pension");
        listOfAcronyms[3] = new Acronyms(4, "KID", "Key Investor Document");
        listOfAcronyms[4] = new Acronyms(5, "MAaD", "My Accounts and Dealing");

        System.out.println("After Array");

        System.out.println("Inside getAcronymsMethod");
        System.out.println(listOfAcronyms[1]);
        return listOfAcronyms;

    }





}

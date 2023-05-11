package com.groupProject.MvAcronymQuizz2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    public MainController(AcronymsRepository u, CategoriesRepository c, AcRepository a, FalseAnswersRepository f) {
        repositoryAcronyms = u;
        repositoryCategories = c;
        repositoryAcMapping = a;
        repositoryFalseAnswers = f;

    }

    private AcronymsRepository repositoryAcronyms;
    private CategoriesRepository repositoryCategories;
    private AcRepository repositoryAcMapping;

    private FalseAnswersRepository repositoryFalseAnswers;


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


    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @GetMapping(path = "/getCategories", consumes = "application/json", produces = "application/json")
    public String getCategories() {

        System.out.println("Hit getCategories API");


        List<Categories> allCategoryEntries = repositoryCategories.findAll();

        String result = "Categories -->";

        for (int i = 0; i < allCategoryEntries.stream().count(); i++) {
            Categories a = allCategoryEntries.get(i);
            if (a != null) {
                result = result + a.getCategory();
            }


        }


        return result;

    }


    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(path = "/addCategory", consumes = "application/json", produces = "application/json")
    public CategoriesVm addCategory(@RequestBody CategoriesVm submittedCategory) {
        System.out.println("Add Category API Called");

        Categories newDataBaseCategory = new Categories();
        newDataBaseCategory.setCategory(submittedCategory.category);


        repositoryCategories.save(newDataBaseCategory);

        return submittedCategory;
    }


    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(path = "/addAcMapping", consumes = "application/json", produces = "application/json")
    public AcVm addAcMapping(@RequestBody AcVm submittedAcMap) {
        System.out.println("Add Category API Called");

        ACs newDataBaseMap = new ACs();
        newDataBaseMap.setCategoryId(submittedAcMap.categoryId);
        newDataBaseMap.setAcronymId(submittedAcMap.acronymId);



        repositoryAcMapping.save(newDataBaseMap);

        return submittedAcMap;
    }



    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @GetMapping(path = "/getFalseAnswers", consumes = "application/json", produces = "application/json")
    public String getFalseAnswers() {

        System.out.println("Hit getFalseAnswers API");


        List<FalseAnswers> allFalseAnswersEntries = repositoryFalseAnswers.findAll();

        String result = "False Answers -->";

        for (int i = 0; i < allFalseAnswersEntries.stream().count(); i++) {
            FalseAnswers a = allFalseAnswersEntries.get(i);
            if (a != null) {
                result = result + a.getFalseAnswer();
            }


        }


        return result;

    }



    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(path = "/addFalseAnswer", consumes = "application/json", produces = "application/json")
    public FalseAnswersVm addFalseAnswer (@RequestBody FalseAnswersVm submittedFalseAnswer) {
        System.out.println("Add Category API Called");

        FalseAnswers newDataBaseFalseAnswer = new FalseAnswers();
        newDataBaseFalseAnswer.setAcronymId(submittedFalseAnswer.acronymId);
        newDataBaseFalseAnswer.setFalseAnswer(submittedFalseAnswer.falseAnswer);



        repositoryFalseAnswers.save(newDataBaseFalseAnswer);

        return submittedFalseAnswer;
    }



    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @GetMapping(path = "/getRandomAcronymId", consumes = "application/json", produces = "application/json")
    public String getRandomAcronymId() {

        System.out.println("Hit getRandomAcronymId API");


        List<Acronyms> allDbAcronyms = repositoryAcronyms.findAll();

        int count = allDbAcronyms.toArray().length;

        Random rn = new Random();
        int randomAcronym = rn.nextInt(count) + 1;

        System.out.println("Random Acronym From Number -> " + " " + ((Acronyms)allDbAcronyms.toArray()[randomAcronym]).getAcronymName());
        System.out.println("Random Acronym Id -> " + " " + ((Acronyms)allDbAcronyms.toArray()[randomAcronym]).getId());

        String result = "Id -->" + ((Acronyms)allDbAcronyms.toArray()[randomAcronym]).getId();

        return result;

    }

    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @GetMapping(path = "/getQuestion", consumes = "application/json", produces = "application/json")
    public FalseAnswersVm getQuestion(@RequestBody FalseAnswersVm request) {

        System.out.println("Hit getQuestion API");

        List<Acronyms> allDbAcronyms = repositoryAcronyms.findAll();

        int count = allDbAcronyms.toArray().length;

        Random rn = new Random();
        int randomAcronym = rn.nextInt(count) + 1;


        String fullQuestion = "What does " + ((Acronyms)allDbAcronyms.toArray()[randomAcronym]).getAcronymName() + "stand for?";
        int idFromRandomAcronym = ((Acronyms)allDbAcronyms.toArray()[randomAcronym]).getId();
        String meaningFromRandomAcronym = ((Acronyms)allDbAcronyms.toArray()[randomAcronym]).getAcronymMeaning();

        List<FalseAnswers> allDbFalseAnswers = repositoryFalseAnswers.findAll();
        ArrayList<String> temporyFalseAnswerStore = new ArrayList<>();
        temporyFalseAnswerStore.add(meaningFromRandomAcronym);

//        Optional<FalseAnswers> falseAnswer = repositoryFalseAnswers.findById(request.id);



        FalseAnswersVm result = new FalseAnswersVm();

        for (int i = 0; i < allDbFalseAnswers.stream().count(); i++) {
            FalseAnswers a = allDbFalseAnswers.get(i);

            int acronymIdToCompare = a.getAcronymId();

            if(a != null) {

                if(acronymIdToCompare == idFromRandomAcronym) {
                     temporyFalseAnswerStore.add(a.getFalseAnswer());
                    System.out.println("Array of potential answers -> " + " " + temporyFalseAnswerStore);
                    result.potentialAnswers = new String[(int)temporyFalseAnswerStore.stream().count()];
                    result.potentialAnswers = (String[])temporyFalseAnswerStore.toArray(result.potentialAnswers);
                }

            }

        }



            return result;

    }



}

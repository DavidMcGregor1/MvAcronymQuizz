package com.groupProject.MvAcronymQuizz2;

public class FalseAnswersVm {
    public int id;
    public int acronymId;
    public String falseAnswer;

    public String[] potentialAnswers;

    FalseAnswersVm(int aid, int aAcronymId, String aFalseAnswer, String[] aPotentialAnswers) {
        id = aid;
        falseAnswer = aFalseAnswer;
        acronymId = aAcronymId;
        potentialAnswers = aPotentialAnswers;

    }

    public FalseAnswersVm() {

    }

    public String FalseAnswer;


}



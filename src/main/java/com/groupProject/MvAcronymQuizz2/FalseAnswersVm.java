package com.groupProject.MvAcronymQuizz2;

public class FalseAnswersVm {
    public int id;
    public int acronymId;
    public String falseAnswer;

    FalseAnswersVm(int aid, int aAcronymId, String aFalseAnswer) {
        id = aid;
        falseAnswer = aFalseAnswer;
        acronymId = aAcronymId;

    }

    public FalseAnswersVm() {

    }


}



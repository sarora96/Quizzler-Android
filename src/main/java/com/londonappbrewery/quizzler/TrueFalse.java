package com.londonappbrewery.quizzler;

/**
 * Created by Sarthak Arora on 7/13/2017.
 */

public class TrueFalse {
    private int question;
    private boolean answer;

    public TrueFalse(int q, boolean a){
        question = q;
        answer = a;
    }

    public boolean getAnswer(){
        return answer;
    }

    public int getQuestion(){
        return question;
    }
}

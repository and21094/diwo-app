package com.aym.android.diwoapp.Model;

/**
 * Created by RafaelAChamorro on 7/3/2017.
 */

public class WriteQuestion {

    private String Question;
    private String answer;

    public WriteQuestion() {}

    public WriteQuestion(String question, String answer) {
        Question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "WriteQuestion{" +
                "Question='" + Question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

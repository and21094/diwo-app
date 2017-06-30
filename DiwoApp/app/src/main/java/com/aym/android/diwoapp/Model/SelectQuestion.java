package com.aym.android.diwoapp.Model;

/**
 * Created by RafaelAChamorro on 6/30/2017.
 */

public class SelectQuestion {

    private String title;
    private String option1;
    private String option2;
    private String option3;

    public SelectQuestion() {}

    public SelectQuestion(String title, String option1, String option2, String option3) {
        this.title = title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    @Override
    public String toString() {
        return "SelectQuestion{" +
                "title='" + title + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                '}';
    }
}

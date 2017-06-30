package com.aym.android.diwoapp.Model;

/**
 * Created by RafaelAChamorro on 6/26/2017.
 */

public class ImageQuestion {

    private String title;
    private ImageOption option1;
    private ImageOption option2;
    private ImageOption option3;
    private ImageOption option4;

    public ImageQuestion() {}

    public ImageQuestion(String title, ImageOption option1, ImageOption option2, ImageOption option3, ImageOption option4) {
        this.title = title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageOption getOption1() {
        return option1;
    }

    public void setOption1(ImageOption option1) {
        this.option1 = option1;
    }

    public ImageOption getOption2() {
        return option2;
    }

    public void setOption2(ImageOption option2) {
        this.option2 = option2;
    }

    public ImageOption getOption3() {
        return option3;
    }

    public void setOption3(ImageOption option3) {
        this.option3 = option3;
    }

    public ImageOption getOption4() {
        return option4;
    }

    public void setOption4(ImageOption option4) {
        this.option4 = option4;
    }

    @Override
    public String toString() {
        return "ImageQuestion{" +
                "title='" + title + '\'' +
                ", option1=" + option1 +
                ", option2=" + option2 +
                ", option3=" + option3 +
                ", option4=" + option4 +
                '}';
    }
}

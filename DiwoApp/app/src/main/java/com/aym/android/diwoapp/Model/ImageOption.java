package com.aym.android.diwoapp.Model;

/**
 * Created by RafaelAChamorro on 6/26/2017.
 */

public class ImageOption {

    private String image;
    private String name;
    private boolean answer;

    public ImageOption() {}

    public ImageOption(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}

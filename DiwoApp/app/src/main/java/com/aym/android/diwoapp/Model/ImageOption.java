package com.aym.android.diwoapp.Model;

/**
 * Created by RafaelAChamorro on 6/26/2017.
 */

public class ImageOption {

    private int image;
    private String name;
    private boolean answer;

    public ImageOption() {}

    public ImageOption(int image, String name, boolean answer) {
        this.image = image;
        this.name = name;
        this.answer = answer;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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

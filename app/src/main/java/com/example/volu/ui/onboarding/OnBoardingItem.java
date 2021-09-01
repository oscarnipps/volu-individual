package com.example.volu.ui.onboarding;

import android.graphics.drawable.Drawable;

public class OnBoardingItem {

    private Drawable image;
    private String title;
    private String description;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

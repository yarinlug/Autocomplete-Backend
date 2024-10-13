package com.example.autocomplete.Model;

public class AutocompleteItem {

    private String imageURL;
    private String workTitle;
    private String name;

    public AutocompleteItem(String imageURL, String workTitle, String name) {
        this.imageURL = imageURL;
        this.workTitle = workTitle;
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public String getName() {
        return name;
    }
}

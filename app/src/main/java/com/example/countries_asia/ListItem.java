package com.example.countries_asia;

public class ListItem {

    private String head;
    private String desc;
    private String subreg;
    private String population;
    private String border;
    private String languages;

    private String imgUrl;

    public ListItem(String head, String desc,String subreg, String population, String border,String languages,String imgUrl) {
        this.head = head;
        this.desc = desc;
        this.subreg = subreg;
        this.population = population;
        this.border = border;
        this.languages = languages;


        this.imgUrl = imgUrl;

    }


    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getSubreg() {
        return subreg;
    }

    public String getPopulation() {
        return population;
    }

    public String getBorder() {
        return border;
    }

    public String getLanguages() {
        return languages;
    }

    public String getImgUrl() {
        return imgUrl;

    }
}

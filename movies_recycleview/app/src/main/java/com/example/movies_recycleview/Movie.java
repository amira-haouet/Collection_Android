package com.example.movies_recycleview;

public class Movie {
    private String year, name,genre;
    private int img;
    public  Movie(String name,String genre,String year,int img)
    {
  this.genre    =genre;
  this.year=year;
  this.name=name;
  this.img=img;
    }


    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}





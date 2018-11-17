package com.pisici.caini.petsearch;
enum species{
    Dog,Cat
}
enum Dog_breed{
    Akita ("Akita"), Pomeranian ("Pomeranian"), Bulldog ("Bulldog");
    private String displayName;
    Dog_breed(String displayName){
        this.displayName=displayName;
    }
    public String displayName() { return displayName; }
    @Override public String toString(){
        return displayName;
    }
}
enum Cat_breed{
    Siamese ("Siamese"), Bengal ("Bengal"), Birman ("Birman");
    private String displayName;
    Cat_breed(String displayName){
        this.displayName=displayName;
    }
    public String displayName() { return displayName; }
    @Override public String toString(){
        return displayName;
    }
}
public class Pet {
    private int year, day, month,number;
    String name;
    species species;
    Dog_breed dog_breed;
    Cat_breed cat_breed;

    public Pet(int year, int day, int month, int number, String name,
               com.pisici.caini.petsearch.species species, Dog_breed dog_breed, Cat_breed cat_breed) {
        this.year = year;
        this.day = day;
        this.month = month;
        this.number = number;
        this.name = name;
        this.species = species;
        this.dog_breed = dog_breed;
        this.cat_breed = cat_breed;
    }
    public Pet(){};

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public com.pisici.caini.petsearch.species getSpecies() {
        return species;
    }

    public Dog_breed getDog_breed() {
        return dog_breed;
    }

    public Cat_breed getCat_breed() {
        return cat_breed;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(com.pisici.caini.petsearch.species species) {
        this.species = species;
    }

    public void setDog_breed(Dog_breed dog_breed) {
        this.dog_breed = dog_breed;
    }

    public void setCat_breed(Cat_breed cat_breed) {
        this.cat_breed = cat_breed;
    }
}

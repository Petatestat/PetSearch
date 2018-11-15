package com.pisici.caini.petsearch;
enum species{
    Dog,Cat
}
enum Dog_breed{
    Akita, Pomeranian, Bulldog, None
}
enum Cat_breed{
    Siamese, Bengal, Birman, None
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

}

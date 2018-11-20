package com.pisici.caini.petsearch;

import java.util.Date;

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
    private int number;
    String name;
    private Date birthday;

    public Pet(int number, String name, Date birtday) {
        this.number = number;
        this.name = name;
        this.birthday = birtday;
    }

    public Pet(){};

    public int getNumber() {
        return number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Dog extends Pet{
        Dog_breed dog_breed;

        public Dog( int number, String name,Date birthday, Dog_breed dog_breed) {
            super(number, name, birthday);
            this.dog_breed = dog_breed;
        }

        public Dog() {}

        public Dog_breed getDog_breed() {
            return dog_breed;
        }

        public void setDog_breed(Dog_breed dog_breed) {
            this.dog_breed = dog_breed;
        }
    }
    public class Cat extends Pet{
        Cat_breed cat_breed;

        public Cat(int number, String name,Date birthday, Cat_breed cat_breed) {
            super(number, name, birthday);
            this.cat_breed = cat_breed;
        }

        public Cat() {}

        public Cat_breed getCat_breed() {
            return cat_breed;
        }

        public void setCat_breed(Cat_breed cat_breed) {
            this.cat_breed = cat_breed;
        }
    }
}

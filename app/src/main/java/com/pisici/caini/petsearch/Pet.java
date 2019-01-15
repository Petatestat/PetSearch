package com.pisici.caini.petsearch;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    Siamese ("Siamese"), Bengal ("Bengal"), Birman ("Birman"), Persan ("Persan"), Ragdoll("Ragdoll"), Sphinx("Sphinx"), Savannah("Savannah"), Mixed("Mixed");
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
    private String id;
    String name;
    private Date birthday;

    public Pet(String id, String name, Date birtday) {
        this.id = id;
        this.name = name;
        this.birthday = birtday;
    }

    public Pet(){};


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Dog extends Pet{
        Dog_breed dog_breed;

        public Dog(String id, String name,Date birthday, Dog_breed dog_breed) {
            super(id, name, birthday);
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
    public static class Cat extends Pet{
        Cat_breed cat_breed;

        public Cat(String id, String name,Date birthday, Cat_breed cat_breed) {
            super(id, name, birthday);
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
    public static String getNewID() {
        // generate random lobby key
        String key = "";
        for (int i = 0; i < 20; ++i) {
            Random r = new Random();
            char rand = (char) (r.nextInt(74) + 48);
            while (rand == 91 || rand == 93) {
                rand = (char) (r.nextInt(74) + 48);
            }
            key += Character.toString(rand);
        }
        return key;
    }
    //TODO: Add age calculator
}

package com.company;

public abstract class Ork extends Race {


    public Ork(String name, String hero_class, int hitPoints, int accuracy, int agility, int mana, int gainMana) {
        super(name, hero_class, hitPoints, accuracy, agility, mana, gainMana);
    }

    abstract void run();

    void death() {
        System.out.println(hero_class + " " + name+ " умирает");
    }

}

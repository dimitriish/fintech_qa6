package com.company;

public abstract class Race {
    String name;
    String hero_class;
    int hitPoints;

    int accuracy;
    int agility;

    int mana;
    int gainMana;


    public Race(String name, String hero_class, int hitPoints, int accuracy, int agility, int mana, int gainMana) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.accuracy = accuracy;
        this.agility = agility;
        this.hero_class = hero_class;
        this.mana = mana;
        this.gainMana = gainMana;
    }


    abstract void run();

    abstract void death();

    abstract int attack();

    abstract void defence(int damage);
}

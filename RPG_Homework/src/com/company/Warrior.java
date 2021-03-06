package com.company;

import java.util.Random;

public class Warrior extends Ork implements Berserk {

    Random random = new Random();

    public Warrior(String name, String hero_class, int hitPoints, int accuracy, int agility, int mana, int gainMana) {
        super(name, hero_class, hitPoints, accuracy, agility, mana, gainMana);
    }

    @Override
    int attack() {
        if (Battle.distance < 10) {
            int choice = random.nextInt(3);
            if (accuracy > random.nextInt(100)) {
                switch (choice) {
                    case 0:
                        return axBlow();
                    case 1:
                        return thrust();
                    case 2:
                        run();
                        return 0;
                    default:
                        return 0;
                }
            } else {
                System.out.println(hero_class + " " + name + " промазал");
                return 0;
            }
        } else {
            run();
            return 0;
        }
    }

    @Override
    void defence(int damage) {
        blockShield(damage);
    }

    @Override
    public int axBlow() {
        if (mana >= 15) {
            mana -= 15;
            System.out.println(hero_class + " " + name + " замахивается и бьет топором");
            return 8;
        } else {
            System.out.println("Не хватило маны на удар");
            return 0;
        }
    }

    @Override
    public void blockShield(int damage) {
        if (mana >= 10) {
            mana -= 10;
            if (random.nextInt(100) < agility) damage /= 2;
            hitPoints -= damage;
            System.out.println(name + " заблокировал часть урона и получил всего " + damage);
        } else {
            System.out.println("Недостаточно маны для блока. Получаете " + damage + " урона");
        }

    }


    @Override
    public int thrust() {
        if (mana >= 15) {
            mana -= 15;
            System.out.println(hero_class + " " + name + " использует разрушительный удар");
            return 10;
        } else {
            System.out.println("Не хватило маны на удар");
            return 0;
        }
    }

    @Override
    void run() {
        Battle.distance -= 5;
        if (Battle.distance < 0) Battle.distance = 0;
        System.out.println("Проклятый " + hero_class + " " + name + " бежит прямо на врага, сократив дистанцию до " + Battle.distance);
    }


}

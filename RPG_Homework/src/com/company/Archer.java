package com.company;

import java.util.Random;
import java.util.Scanner;

public class Archer extends Elf implements Shooter, Mage {
    Scanner in = new Scanner(System.in);
    Random random = new Random();


    public Archer(String name, String hero_class, int hitPoints, int accuracy, int agility, int mana, int gainMana) {
        super(name, hero_class, hitPoints, accuracy, agility, mana, gainMana);
    }

    @Override
    void run() {
        Battle.distance += 3;
        System.out.println(name + " отступает. Дистанция теперь " + Battle.distance);
    }

    @Override
    int attack() {
        System.out.println("\nВыберите атаку:\n" +
                "1. accurateShot: 10 маны; 3 урона\n" +
                "2. stormOfArrows: 30 маны 6 урона\n" +
                "3. fireball: 15 маны; 4 урона\n" +
                "4. run: 0 маны, увеличивает расстояние на 3 метра");
        int choice = in.nextInt();

        if (accuracy > random.nextInt(100)) {
            switch (choice) {
                case 1:
                    return accurateShot();
                case 2:
                    return stormOfArrows();
                case 3:
                    return fireball();
                case 4:
                    run();
                    return 0;
                default:
                    System.out.println("Неверный выбор, пропуск хода");
                    return 0;
            }
        } else {
            System.out.println(name + " промахивается");
            return 0;
        }
    }

    @Override
    void defence(int damage) {
        System.out.println("\nВыберите защиту:\n" +
                "1. dodge: 10 маны; В зависимости от вашей ловкости позволяет избежать урона\n" +
                "2. heal: 10 маны; Восстанавливает 2 хп");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                dodge(damage);
                break;
            case 2:
                heal(damage);
                break;
            default:
                System.out.println("Неверный выбор, пропуск хода");
                hitPoints -= damage;
        }
    }

    @Override
    public int accurateShot() {
        if (mana >= 10) {
            mana -= 10;
            System.out.println(hero_class + " " + name + " метко выпускает стрелу");
            return 3;
        } else {
            System.out.println("Не хватает маны");
            return 0;
        }
    }

    @Override
    public int stormOfArrows() {
        if (mana >= 30) {
            System.out.println(name + " выпускает целую бурю стрел");
            mana -= 30;
            return 6;
        } else {
            System.out.println("Не хватает маны");
            return 0;
        }
    }

    @Override
    public int fireball() {
        if (mana >= 15) {
            System.out.println(hero_class + " " + name + " бросает огненный шар");
            mana -= 15;
            return 4;
        } else {
            System.out.println("Не хватает маны");
            return 0;
        }
    }

    @Override
    public void dodge(int damage) {
        if (mana >= 10) {
            mana -= 10;
            if (random.nextInt(300) > agility) {
                System.out.println(name + " перекатывается в лучших традициях Dark Souls, но получает " + damage + " урона");
                hitPoints -= damage;
            } else {
                System.out.println(name + " перекатывается в лучших традициях Dark Souls и избегает урона");
            }
        } else {
            System.out.println("Не хватает маны");
            System.out.println("Перекат не удался. " + name + " получает " + damage + " урона");
            hitPoints -= damage;
        }
    }

    @Override
    public void heal(int damage) {
        if (mana >= 10) {
            mana -= 10;
            hitPoints += 2;
            System.out.println("Получает урона " + damage + ", восстанавливает 2");
        } else {
            System.out.println("Не хватает маны");
            System.out.println("Перекат не удался. " + name + " получает " + damage + " урона");
        }
        hitPoints -= damage;
    }


}

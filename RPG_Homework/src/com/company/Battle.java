package com.company;

public class Battle {
    static int distance = 10;

    public static void start() {
        Archer archer = new Archer("Андрей", "лучник-маг", 5, 90, 70, 40, 20);
        Warrior warrior = new Warrior("Гаррош", "воин", 7, 80, 60, 60, 15);

        System.out.println("Битва начинается!\n");

        while ((archer.hitPoints > 0) && (warrior.hitPoints > 0)) {
            archer.defence(warrior.attack());
            warrior.defence(archer.attack());

            archer.mana += archer.gainMana;
            warrior.mana += archer.gainMana;

            System.out.println("\n" +
                    archer.name + " " + archer.hitPoints + " хп, " + archer.mana + " маны\n" +
                    warrior.name + " " + warrior.hitPoints + " хп, " + warrior.mana + " маны\n" +
                    "\n");
        }
        if ((archer.hitPoints <= 0) && (warrior.hitPoints <= 0)) {
            archer.death();
            warrior.death();
            System.out.println("Ничья");
        }else if((archer.hitPoints <= 0)){
            archer.death();
            System.out.println("Победил " + warrior.name);
        }else{
            warrior.death();
            System.out.println("Победил " + archer.name);
        }



    }
}

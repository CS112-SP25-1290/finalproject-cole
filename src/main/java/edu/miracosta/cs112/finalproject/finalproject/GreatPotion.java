package edu.miracosta.cs112.finalproject.finalproject;

public class GreatPotion extends Potion{
    public GreatPotion(int potionsLeft, int potionsMax) {
        super(potionsLeft, potionsMax);
    }

    public void heal(Pokemon pokemon){
        int potionsLeft = this.getPotionsLeft();
        if (potionsLeft > 0) {
            int currentHp = pokemon.getHp();
            int maxHp = pokemon.getMaxHP();

            if (currentHp > 0) {
                if (currentHp + 20 > maxHp) {
                    pokemon.setHp(maxHp);
                    System.out.println(pokemon.getName() + " was healed to max HP of " + maxHp);
                    System.out.println();
                } else {
                    pokemon.setHp(currentHp + 20);
                    System.out.println(pokemon.getName() + " was healed to a HP of " + pokemon.getHp());
                    System.out.println();
                }

                this.setPotionsLeft(potionsLeft - 1);
            } else {
                System.out.println(pokemon.getName() + " is knocked out");
                System.out.println();
            }
        } else {
            System.out.println("You are out of potion!");
            System.out.println();
        }
    }
}

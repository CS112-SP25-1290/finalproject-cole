package edu.miracosta.cs112.finalproject.finalproject;
import java.util.Random;

public class BotPlayer extends Player {

    public BotPlayer(Pokemon[] pokemons, Potion[] potions,int pokemonCount) {
        super(pokemons, potions, pokemonCount);
    }

    public void switchPokemon() throws OutOfPokemons{
        int pokemonLeft = this.getPokemonCount();

        if (pokemonLeft <= 1) {
            throw new OutOfPokemons("Bot ran out of Pokemons!");
        }

        this.setPokemonCount(pokemonLeft - 1);
        int nextPokemonIndex = this.getPokemons().length - pokemonLeft + 1;
        this.setCurrentPokemon(this.getPokemons()[nextPokemonIndex]);
    }

    public void commandAttack(Pokemon opponentPokemon) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(4); //random int form 0-3
        Pokemon currentPokemon = this.getCurrentPokemon();
        AttackMove move = currentPokemon.getMoveSet()[randomIndex];
        currentPokemon.attack(move, opponentPokemon);
    }

    public void healPokemon() {
        int potionsLeft = this.getPotions()[0].getPotionsLeft();
        if (potionsLeft > 0) {
            int currentHp = this.getCurrentPokemon().getHp();
            int maxHp = this.getCurrentPokemon().getMaxHP();

            if (currentHp > 0) {
                System.out.println(this.getCurrentPokemon().getName() + " HP was originally " + currentHp);

                if (currentHp + 50 > maxHp) {
                    this.getCurrentPokemon().setHp(maxHp);
                    System.out.println("And was healed to max HP of " + maxHp);
                } else {
                    this.getCurrentPokemon().setHp(currentHp + 50);
                    System.out.println(this.getCurrentPokemon().getName() + " was healed to a HP of " + this.getCurrentPokemon().getHp());
                }

                this.getPotions()[0].setPotionsLeft(potionsLeft - 1);
            } else {
                System.out.println(this.getCurrentPokemon().getName() + " is knocked out");
            }
        } else {
            System.out.println("You are out of potion!");
        }
    }
}

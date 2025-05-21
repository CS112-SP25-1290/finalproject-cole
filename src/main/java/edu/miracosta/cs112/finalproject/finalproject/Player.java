package edu.miracosta.cs112.finalproject.finalproject;

import edu.miracosta.cs112.finalproject.finalproject.Pokemons.Chimchar;

public class Player {
    private Pokemon[] pokemons;
    private Potion[] potions;
    private Pokemon currentPokemon;
    private int pokemonCount;

    public Player(Pokemon[] pokemons, Potion[] potions,int pokemonCount) {
        this.setAll(pokemons, potions, pokemons[0], pokemonCount);
    }

    public Player(Player copy) {
        this.setAll(copy.pokemons, copy.potions, copy.currentPokemon, copy.pokemonCount);
    }

    public void setPokemons(Pokemon[] pokemons) {
        if (pokemons != null && pokemons.length <= 6) {
            this.pokemons = pokemons;
            this.setPokemonCount(pokemons.length);
        }
    }

    public void setPotions(Potion[] potions) {
        if(potions != null) {
            this.potions = potions;
        }
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public void setPokemonCount(int pokemonCount) {
        if (pokemonCount >= 0 && pokemonCount <= 6) {
            this.pokemonCount = pokemonCount;
        }
    }

    public void setAll(Pokemon[] pokemons, Potion[] potions, Pokemon currentPokemon,int pokemonCount) {
        this.setPokemons(pokemons);
        this.setPotions(potions);
        this.setCurrentPokemon(currentPokemon);
        this.setPokemonCount(pokemonCount);
    }

    public Pokemon[] getPokemons() {
        return this.pokemons;
    }

    public Potion[] getPotions() {
        return this.potions;
    }

    public Pokemon getCurrentPokemon() {
        return this.currentPokemon;
    }

    public int getPokemonCount() {
        return this.pokemonCount;
    }

    @Override
    public String toString() {
        String pokemonNames = "";
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null) {
                pokemonNames += pokemons[i].getName();
                if (i < pokemons.length - 1 && pokemons[i + 1] != null) {
                    pokemonNames += ", ";
                }
            }
        }
        return "Player: Pokemons = [" + pokemonNames + "]" +
                ", Potions = [" + potions + "]" +
                ", CurrentPokemon = " + this.currentPokemon +
                ", PokemonCount = " + this.pokemonCount;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            Player otherPlayer = (Player)other;
            if(!this.currentPokemon.equals(otherPlayer.getCurrentPokemon())) {
                return false;
            }
            if (this.pokemonCount != otherPlayer.pokemonCount) {
                return false;
            }
            if (this.pokemons == null && otherPlayer.pokemons != null || this.pokemons != null && otherPlayer.pokemons == null) {
                return false;
            }
            if (this.pokemons != null && otherPlayer.pokemons != null) {
                if (this.pokemons.length != otherPlayer.pokemons.length) {
                    return false;
                }
                for (int i = 0; i < this.pokemons.length; i++) {
                    if (!this.pokemons[i].equals(otherPlayer.pokemons[i])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void healPokemon(int index) {
        Potion potion = this.getPotions()[index];
        int potionsLeft = potion.getPotionsLeft();
        potion.heal(this.currentPokemon);
    }
}

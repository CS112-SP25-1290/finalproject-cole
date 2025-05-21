package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Magikarp extends Pokemon {
    public Magikarp() {
        super("Magikarp", "Water", "/PokemonImages/Magikarp.png", 100, 100,
                new AttackMove[]{
                        new Cut(),
                        new DizzyPunch(),
                        new AquaTail(),
                        new Dive()});
    }
}

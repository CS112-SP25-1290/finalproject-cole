package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Blastoise extends Pokemon {
    public Blastoise() {
        super("Blastoise", "Water", "/PokemonImages/Blastoise.png", 250, 250,
                new AttackMove[]{
                        new HydroCannon(),
                        new Whirlpool(),
                        new AquaTail(),
                        new Dive()});
    }
}

package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Serperior extends Pokemon {
    public Serperior() {
        super("Serperior", "Grass", "/PokemonImages/Serperior.png", 250, 250,
                new AttackMove[]{
                        new Cut(),
                        new Absorb(),
                        new LeafStorm(),
                        new VineWhip()});
    }
}

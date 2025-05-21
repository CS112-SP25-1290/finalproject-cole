package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Treecko extends Pokemon {
    public Treecko() {
        super("Treecko", "Grass", "/PokemonImages/Treecko.png", 100, 100,
                new AttackMove[]{
                        new Cut(),
                        new DizzyPunch(),
                        new LeafStorm(),
                        new VineWhip()});
    }
}

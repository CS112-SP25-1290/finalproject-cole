package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.AquaTail;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Cut;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.Dive;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.DizzyPunch;

public class Oshawott extends Pokemon {
    public Oshawott() {
        super("Oshawott", "Water", "/PokemonImages/Oshawott.png", 100, 100,
                new AttackMove[]{
                        new Cut(),
                        new DizzyPunch(),
                        new AquaTail(),
                        new Dive()});
    }
}

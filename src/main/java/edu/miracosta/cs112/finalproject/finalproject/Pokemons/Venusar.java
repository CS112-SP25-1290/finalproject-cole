package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Venusar extends Pokemon {
    public Venusar() {
        super("Venusar", "Grass", "/PokemonImages/Venusar.png", 250, 250,
                new AttackMove[]{
                        new Absorb(),
                        new SolarBeam(),
                        new LeafStorm(),
                        new VineWhip()});
    }
}

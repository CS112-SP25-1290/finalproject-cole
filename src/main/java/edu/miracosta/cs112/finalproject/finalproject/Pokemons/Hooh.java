package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Hooh extends Pokemon {
    public Hooh() {
        super("Ho-oh", "Fire", "/PokemonImages/Ho-oh.png", 350, 350,
                new AttackMove[]{
                        new Inferno(),
                        new Ember(),
                        new FireBlast(),
                        new Overheat()});
    }
}

package edu.miracosta.cs112.finalproject.finalproject.Pokemons;

import edu.miracosta.cs112.finalproject.finalproject.AttackMove;
import edu.miracosta.cs112.finalproject.finalproject.Pokemon;
import edu.miracosta.cs112.finalproject.finalproject.moveSet.*;

public class Chimchar extends Pokemon {
    public Chimchar() {
        super("Chimchar", "Fire", "/PokemonImages/Chimchar.png", 100, 100,
                new AttackMove[]{
                        new Cut(),
                        new Ember(),
                        new FireBlast(),
                        new DizzyPunch()});
    }
}

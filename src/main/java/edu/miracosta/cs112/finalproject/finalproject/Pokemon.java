package edu.miracosta.cs112.finalproject.finalproject;

abstract class Pokemon {
    private String name;
    private String type;
    private int hp;
    private AttackMove[] moveSet;

    public Pokemon(String name, String type, int hp, AttackMove[] moveSet) {
        this.setAll(name, type, hp, moveSet);
    }

    public Pokemon() {
        this.setAll("Pikachu", "Electric", 100, null);
    }

    public Pokemon(Pokemon copy) {
        this.setAll(copy.name, copy.type, copy.hp, copy.moveSet);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMoveSet(AttackMove[] moveSet) {
        this.moveSet = moveSet;
    }

    public void setAll(String name, String type, int hp, AttackMove[] moveSet) {
        this.setName(name);
        this.setType(type);
        this.setHp(hp);
        this.setMoveSet(moveSet);
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getHp() {
        return this.hp;
    }

    public AttackMove[] getMoveSet() {
        return this.moveSet;
    }

    // OTHER REQUIRED METHODS
    @Override
    public String toString() {
        String moves = "";
        for (int i = 0; i < moveSet.length; i++) {
            if (moveSet[i] != null) {
                moves += moveSet[i].getName();
                if (i < moveSet.length - 1 && moveSet[i + 1] != null) {
                    moves += ", ";
                }
            }
        }
        return "Pokemon: Name = " + this.name +
                ", Type = " + this.type +
                ", HP = " + this.hp +
                ", MoveSet = [" + moves + "]";
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            Pokemon otherPokemon = (Pokemon)other;
            if (this.hp != otherPokemon.hp) {
                return false;
            }
            if (!this.name.equals(otherPokemon.name)) {
                return false;
            }
            if (!this.type.equals(otherPokemon.type)) {
                return false;
            }
            if (this.moveSet == null && otherPokemon.moveSet != null || this.moveSet != null && otherPokemon.moveSet == null) {
                return false;
            }
            if (this.moveSet != null && otherPokemon.moveSet != null) {
                if (this.moveSet.length != otherPokemon.moveSet.length) {
                    return false;
                }
                for (int i = 0; i < this.moveSet.length; i++) {
                    if (!this.moveSet[i].equals(otherPokemon.moveSet[i])) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    abstract void attack(Pokemon opponentPokemon);
}

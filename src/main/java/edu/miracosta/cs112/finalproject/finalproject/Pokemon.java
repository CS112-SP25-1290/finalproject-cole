package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Objects;

public class Pokemon {
    private String name;
    private String type;
    private String imagePath;
    private int maxHP;
    private int hp;
    private AttackMove[] moveSet;

    public Pokemon(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        this.setAll(name, type, imagePath, maxHP, hp, moveSet);
    }

    public Pokemon() {
        this.setAll("Pikachu", "Electric", "N/A", 100, 100, null);
    }

    public Pokemon(Pokemon copy) {
        this.setAll(copy.name, copy.type, copy.imagePath, copy.maxHP ,copy.hp, copy.moveSet);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMoveSet(AttackMove[] moveSet) {
        this.moveSet = moveSet;
    }

    public void setAll(String name, String type, String imagePath, int maxHP, int hp, AttackMove[] moveSet) {
        this.setName(name);
        this.setType(type);
        this.setImagePath(imagePath);
        this.setMaxHP(maxHP);
        this.setHp(hp);
        this.setMoveSet(moveSet);
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public int getMaxHP() {
        return this.maxHP;
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
                moves += moveSet[i].getAttackName();
                if (i < moveSet.length - 1 && moveSet[i + 1] != null) {
                    moves += ", ";
                }
            }
        }
        return "Pokemon: Name = " + this.name +
                ", Type = " + this.type +
                ", ImagePath = " + this.imagePath +
                ", MaxHP = " + this.maxHP +
                ", HP = " + this.hp +
                ", MoveSet = [" + moves + "]";
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            Pokemon otherPokemon = (Pokemon)other;
            if (!this.name.equals(otherPokemon.name)) {
                return false;
            }
            if (!this.type.equals(otherPokemon.type)) {
                return false;
            }
            if (!this.imagePath.equals(otherPokemon.imagePath)) {
                return false;
            }
            if (this.maxHP != otherPokemon.maxHP) {
                return false;
            }
            if (this.hp != otherPokemon.hp) {
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

    public boolean attack(AttackMove attackMove, Pokemon opponentPokemon) {
        attackMove.setAttacksLeft(attackMove.getAttacksLeft() - 1);
        int currentOppHP = opponentPokemon.getHp();
        int damage = attackMove.getDamageAmount();

        //Fire Attack
        if (Objects.equals(attackMove.getType(), "Fire")) {
            if (Objects.equals(opponentPokemon.getType(), "Water")) {
                damage *= 0.2;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");

                System.out.println("Fire is not so effective against Water\n");
            } else if (Objects.equals(opponentPokemon.getType(), "Grass")) {
                damage *= 1.5;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Fire is very effective against Grass\n");
            } else {
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".\n");
            }
        }

        //Water Attack
        else if (Objects.equals(attackMove.getType(), "Water")) {
            if (Objects.equals(opponentPokemon.getType(), "Grass")) {
                damage *= 0.2;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Water is not so effective against Grass\n");
            } else if (Objects.equals(opponentPokemon.getType(), "Fire")) {
                damage *= 1.5;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Water is very effective against Fire\n");
            } else {
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".\n");
            }
        }

        //Grass Attack
        else if (Objects.equals(attackMove.getType(), "Grass")) {
            if (Objects.equals(opponentPokemon.getType(), "Fire")) {
                damage *= 0.2;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Grass is not so effective against Fire\n");
            } else if (Objects.equals(opponentPokemon.getType(), "Water")) {
                damage *= 1.5;
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".");
                System.out.println("Grass is very effective against Water\n");
            } else {
                opponentPokemon.setHp(currentOppHP - (int) damage);
                System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".\n");
            }
        } else {
            opponentPokemon.setHp(currentOppHP - (int) damage);
            System.out.println(attackMove.getAttackName() + " was used and dealt " + damage + " damage to " + opponentPokemon.getName() + ".\n");
        }


        if(opponentPokemon.getHp() < 0) {
            System.out.println(opponentPokemon.getName() + " was knocked out!");
            return false;
        } else {
            return true;
        }
    }
}

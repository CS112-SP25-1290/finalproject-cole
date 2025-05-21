package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Objects;

public abstract class Potion {
    private int potionsLeft;
    private int potionsMax;

    public Potion(int potionsLeft, int potionsMax) {
        this.potionsLeft = potionsLeft;
        this.potionsMax = potionsMax;
    }

    public int getPotionsLeft() {
        return potionsLeft;
    }

    public int getPotionsMax() {
        return potionsMax;
    }

    public void setPotionsLeft(int potionsLeft) {
        this.potionsLeft = potionsLeft;
    }

    public void setPotionsMax(int potionsMax) {
        this.potionsMax = potionsMax;
    }

    public abstract void heal(Pokemon pokemon);

    @Override
    public String toString() {
        return "Potion{" +
                "potionsLeft=" + potionsLeft +
                ", potionsMax=" + potionsMax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Potion)) return false;
        Potion potion = (Potion) o;
        return potionsLeft == potion.potionsLeft &&
                potionsMax == potion.potionsMax;
    }
}
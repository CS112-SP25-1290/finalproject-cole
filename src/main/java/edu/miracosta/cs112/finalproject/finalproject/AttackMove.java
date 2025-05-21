package edu.miracosta.cs112.finalproject.finalproject;

public class AttackMove {
    private String attackName;
    private String type;
    private int damageAmount;
    private int maxAttackCount;
    private int attacksLeft;

    public AttackMove() {
        this.setAll("N/A", "N/A", -1, -1, -1);
    }

    public AttackMove(String attackName, String type, int damageAmount, int maxAttackCount, int attacksLeft) {
        this.setAll(attackName, type, damageAmount, maxAttackCount, attacksLeft);
    }

    public AttackMove(AttackMove copy) {
        this.setAll(copy.attackName, copy.type, copy.damageAmount, copy.maxAttackCount, copy.attacksLeft);
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

    public void setMaxAttackCount(int maxAttackCount) {
        this.maxAttackCount = maxAttackCount;
    }

    public void setAttacksLeft(int attacksLeft) {
        this.attacksLeft = attacksLeft;
    }

    public void setAll(String attackName, String type, int damageAmount, int maxAttackCount, int attacksLeft) {
        this.setAttackName(attackName);
        this.setType(type);
        this.setDamageAmount(damageAmount);
        this.setMaxAttackCount(maxAttackCount);
        this.setAttacksLeft(attacksLeft);
    }

    public String getAttackName() {
        return this.attackName;
    }

    public String getType() {
        return this.type;
    }

    public int getDamageAmount() {
        return this.damageAmount;
    }

    public int getMaxAttackCount() {
        return this.maxAttackCount;
    }

    public int getAttacksLeft() {
        return this.attacksLeft;
    }

    @Override
    public String toString() {
        return "AttackMove: AttackName = " + this.attackName +
                ", Type = " + this.type +
                ", DamageAmount = " + this.damageAmount +
                ", MaxAttacks = " + this.maxAttackCount +
                ", AttacksLeft = " + this.attacksLeft;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            AttackMove otherAttackMove = (AttackMove)other;
            if (!this.attackName.equals(otherAttackMove.attackName)) {
                return false;
            }
            if (!this.type.equals(otherAttackMove.type)) {
                return false;
            }
            if (this.damageAmount != otherAttackMove.damageAmount) {
                return false;
            }
            if (this.maxAttackCount != otherAttackMove.maxAttackCount) {
                return false;
            }
            if (this.attacksLeft != otherAttackMove.attacksLeft) {
                return false;
            }
        }

        return true;
    }
}

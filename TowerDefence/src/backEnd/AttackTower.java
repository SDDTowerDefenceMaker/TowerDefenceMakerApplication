package backEnd;

public class AttackTower {

    private AttackTower() {
	}

    // Attributes
    private int attack;
    private int attackRate;
    private CoordinatesFacotry attackRegion;
    private int defense;
    private int healthPoint;
    private boolean isActive;
    private int AttacktowerCoins;

    // Functions
    private int getAttack() {
        int a = attack;
        return a;
    }
    private int getAttackRate() {
        int ar = attackRate;
        return ar;
    }
    private CoordinatesFacotry getAttackRegion() {
        CoordinatesFacotry aregion = attackRegion;
        return aregion;
    }
    private int getDefense() {
        int d = defense;
        return d;
    }
    private int getHealth() {
        int hp = healthPoint;
        return hp;
    }
    private boolean getIsActive() {
        boolean ia = isActive;
        return ia;
    }
    private int getTowerCoins() {
        int atc = AttacktowerCoins;
        return atc;
    }

    private int calculateActualDamage(int monsterDamage) {
        int actualDamage = 0;
        actualDamage = monsterDamage / (1 + defense/100);
        return actualDamage;
    }
    private void calculateHealthRemaining(int actualDamage) {
        healthPoint = Math.min(0, healthPoint - actualDamage);
        if(healthPoint == 0) { isActive = false; }
    }

}


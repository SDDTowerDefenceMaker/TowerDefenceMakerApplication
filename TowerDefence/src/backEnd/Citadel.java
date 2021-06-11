package backEnd;

public class Citadel {
 
    private Citadel() {
	}

    // Attributes
    private int attack;
    private int attackRate;
    private CoordinatesFacotry attackRegion;
    private int defense;
    private int healthPoint;
    private boolean isActive;
    private int coins;

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
    private int getCoins() {
        int c = coins;
        return c;
    }

    private int calculateActualDamage(int monsterDamage) {
        int actualDamage = 0;
        actualDamage = monsterDamage / (1 + defense/100);
        return actualDamage;
    }
    private void calculateHealthRemaining(int actualDamage) {
        healthPoint = min(0, healthPoint - actualDamage);
        if(healthPoint == 0) { isActive = false; }
    }

    // The citadel obtains coins when monsters are killed
    private void obtainCoins(int monsterCoins) {
        coins += monsterCoins;
    }
    // The citadel spends coins when towers are built
    private void spendCoins(int TowerCoins) {
        if(coins < TowerCoins) { return; }
        coins -= TowerCoins;
    }
    
}

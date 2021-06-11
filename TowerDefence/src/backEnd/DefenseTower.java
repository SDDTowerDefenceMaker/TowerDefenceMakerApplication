package backEnd;

public class DefenseTower {

    private DefenseTower() {
	}

    // Attributes
    private int defense;
    private int healthPoint;
    private boolean isActive;
    private int defenseTowerCoins;

    // Functions
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
        int dtc = defenseTowerCoins;
        return dtc;
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
    
}

package backEnd;

public class Monster {

    private Monster() {
	}

    // Attributes
    private int attack;
    private int attackRate;
    private int defense;
    private int healthPoint;
    private boolean isActive;
    private int monsterCoins;
    private Path monsterPath;

    // Functions
    private int getAttack() {
        int a = attack;
        return a;
    }
    private int getAttackRate() {
        int ar = attackRate;
        return ar;
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
    private int getMonsterCoins() {
        int mc = monsterCoins;
        return mc;
    }
    private Path getPath() {
        Path p = monsterPath;
        return p;
    }

    private int calculateActualDamage(int towerDamage) {
        int actualDamage = 0;
        actualDamage = towerDamage / (1 + defense/100);
        return actualDamage;
    }
    private void calculateHealthRemaining(int actualDamage) {
        healthPoint = min(0, healthPoint - actualDamage);
        if(healthPoint == 0) { isActive = false; }
    }

}

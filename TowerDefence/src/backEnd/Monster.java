package backEnd;

public class Monster {
	public MonsterType property;

    public Monster() {
    	property=MonsterTypeFactory.
	}



    private int calculateActualDamage(int towerDamage) {
        int actualDamage = 0;
        actualDamage = towerDamage / (1 + defense/100);
        return actualDamage;
    }
    private void calculateHealthRemaining(int actualDamage) {
        healthPoint = Math.min(0, healthPoint - actualDamage);
        if(healthPoint == 0) { isActive = false; }
    }

}

package backEnd;
import java.lang.Math;

public class SingleTargetTower implements Tower {

    public SingleTargetTower() {
        damage = 100;
        fireRate = 1;
        attackRange = new Range();
        position = new Range();
        defense = 10;
        healthPoint = 1000;
        isActive = true;
        buildCost = 50;
    }

    // Attributes
    private Range attackRange;
    private int buildCost;
    private int damage;
    private int defense;
    private int fireRate;
    private int healthPoint;
    private boolean isActive;
    private String towerName;
    private Range position;
    

    @Override
    public void buildTower(Range p) {}


    // ACCESSORS
    
    @Override
    public Range getAttackRange() {
        Range r = new Range(attackRange);
        return r;
    }
    @Override
    public int getBuildCost() {
        int bc = buildCost;
        return bc;
    }
    @Override
    public int getDamage() {
        int d = damage;
        return d;
    }
    @Override
    public int getDefense() {
        int d = defense;
        return d;
    }
    @Override
    public int getFireRate() {
        int fr = fireRate;
        return fr;
    }
    @Override
    public int getHealthPoint() {
        int hp = healthPoint;
        return hp;
    }
    @Override
    public boolean getIsActive() {
        boolean active = isActive;
        return active;
    }
    @Override
    public String getName() {
        String n = towerName;
        return n;
    }


    // MODIFIERS

    @Override
    public void Activate() {
        isActive = true;
    }
    @Override
    public void Inactivate() {
        isActive = false;
    }
    @Override
    public void setAttackRange(Range arange) {
        if (arange.isIn(position)) {
            attackRange.copyRange(arange);;
        }
    }
    @Override
    public void setBuildCost(int bc) {
        buildCost = bc;
    }
    @Override
    public void setDamage(int d) {
        damage = d;
    }
    @Override
    public void setDefense(int d) {
        defense = d;
    }
    @Override
    public void setFireRate(int fr) {
        fireRate = fr;
    }
    @Override
    public void setHealthPoint(int hp) {
        healthPoint = hp;
    }
    @Override
    public void setName(String n) {
        towerName = n;
    }
    

}


package backEnd;
import java.lang.Math;

public class SingleTargetTower implements Tower {

    public SingleTargetTower(String tn) {
        towerName = tn;
    }

    // Attributes
    private Range attackRange;
    private Double buildCost;
    private Double damage = 100;;
    private Double defense = 25;
    private double fireRate = 1;
    private Double healthPoint = 1000;
    private boolean isActive = true;
    private Range position = new Range();
    private String towerName = "UNTITLED";
    

    @Override
    public void buildTower(Range p) {}

    // ACCESSORS
    @Override
    public Range getAttackRange() {
        Range r = new Range(attackRange);
        return r;
    }
    @Override
    public Double getBuildCost() {
        Double bc = buildCost;
        return bc;
    }
    @Override
    public Double getDamage() {
        Double d = damage;
        return d;
    }
    @Override
    public Double getDefense() {
        Double d = defense;
        return d;
    }
    @Override
    public Double getFireRate() {
        Double fr = fireRate;
        return fr;
    }
    @Override
    public Double getHealthPoint() {
        Double hp = healthPoint;
        return hp;
    }
    @Override
    public boolean getIsActive() {
        boolean active = isActive;
        return active;
    }
    @Override
    public String getPosition() {
        Range r = new Range(position);
        return r;
    }
    @Override
    public String getTowerName() {
        String n = towerName;
        return n;
    }
    @Override
    public String getTowerType() {
        return "SingleTargetTower";
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
    public void setAttackRange(Range arange, position) {
        if (arange.isIn(position)) {
            attackRange.copyRange(arange);;
        }
    }
    @Override
    public void setBuildCost(Double bc) {
        buildCost = bc;
    }
    @Override
    public void setDamage(Double d) {
        damage = d;
    }
    @Override
    public void setDefense(Double d) {
        defense = d;
    }
    @Override
    public void setFireRate(Double fr) {
        fireRate = fr;
    }
    @Override
    public void setHealthPoint(Double hp) {
        healthPoint = Math.max(0, hp);
    }
    @Override
    public String setPosition(Range r) {
        if ( r.isIn(attackRange) ) {
            position.copyRange(r);
        }
    }
    @Override
    public void setTowerName(String n) {
        towerName = n;
    }
    

}


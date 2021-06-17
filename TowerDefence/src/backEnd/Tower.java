package backEnd;

public interface Tower {
    
    public void buildTower(String towerName, Range position);

    // ACCESSORS
    public Range getAttackRange();
    public Double getBuildCost();
    public Double getDamage();
    public Double getDefense();
    public Double getFireRate();
    public Double getHealthPoint();
    public boolean getIsActive();
    public Range getPosition();
    public String getTowerName();
    public String getTowerType();

    // MODIFIERS
    public void Activate();
    public void Inactivate();
    public void setAttackRange(Range arange);
    public void setBuildCost(Double bc);
    public void setDamage(Double d);
    public void setDefense(Double d);
    public void setFireRate(Double fr);
    public void setHealthPoint(Double hp);
    public void setPosition(Range r);
    public void setTowerName(String n);


}

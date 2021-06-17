package backEnd;

public interface Tower {
    
    public void buildTower(Range p);

    // ACCESSORS
    public Range getAttackRange();
    public int getBuildCost();
    public int getDamage();
    public int getDefense();
    public int getFireRate();
    public int getHealthPoint();
    public boolean getIsActive();
    public String getName();

    // MODIFIERS
    public void Activate();
    public void Inactivate();
    public void setAttackRange(Range arange);
    public void setBuildCost(int bc);
    public void setDamage(int d);
    public void setDefense(int d);
    public void setFireRate(int fr);
    public void setHealthPoint(int hp);
    public void setName(String n);

}

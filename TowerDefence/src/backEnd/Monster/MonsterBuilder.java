package backEnd.Monster;

import backEnd.Coordinate;

public abstract class MonsterBuilder {

    // build monster
    protected Monster m = new Monster();
    public abstract void buildMonsterType(MonsterType mt);
    public abstract void buildMonsterPosition(Coordinate p);
    
    // return monster
    public Monster getResult() {
        return m;
    }
}

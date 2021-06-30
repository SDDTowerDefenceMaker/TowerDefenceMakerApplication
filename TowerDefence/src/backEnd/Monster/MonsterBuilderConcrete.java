package backEnd.Monster;
import backEnd.Coordinate;

public class MonsterBuilderConcrete extends MonsterBuilder {

    @Override
    public void buildMonsterType(MonsterType mt) {
        m.setMonsterType(mt);
    }
    @Override
    public void buildMonsterPosition(Coordinate p) {
        m.setMonsterPosition(p);
    }
    
}
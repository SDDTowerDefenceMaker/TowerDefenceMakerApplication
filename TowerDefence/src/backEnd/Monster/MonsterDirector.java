package backEnd.Monster;

public class MonsterDirector {

    private MonsterBuilder monsterBuilder;

    public MonsterDirector(MonsterBuilder mb) {
        this.monsterBuilder = mb;
    }

    //产品构建与组装方法
    public Monster create() {
        return monsterBuilder.getResult();
    }
}

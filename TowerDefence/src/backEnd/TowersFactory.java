package backEnd;

public class TowersFactory {
    public static final int TYPE_ATTACK = 1; //AttackTower
    public static final int TYPE_DEFENSE = 2; //DefenseTower
    public static final int TYPE_CITADEL = 3; //Citadel

    public static Tower buildTower(int towerType) {
        switch (towerType) {
            case TYPE_ATTACK:
                return new SingleTargetTower();
            case TYPE_DEFENSE:
                return new AOETower();
            case TYPE_CITADEL:
            default:
                return new Citadel();
        }
    }

    public void ActivateTower();
    public void InactivateTower();

}
package backEnd;
import java.lang.*

public class TowersFactory {
    public static final int TYPE_AOE = 1; //AOETower
    public static final int TYPE_SINGLE = 2; //SingleTargetTower
    public static final int TYPE_CITADEL = 3; //Citadel

    public static Tower buildTower(int towerType， String towerName, Range position) {
        switch (towerType) {
            case TYPE_AOE:
                return new AOETower(towerName, position);
            case TYPE_SINGLE:
                return new SingleTargetTower(towerName, position);
            case TYPE_CITADEL:
            default:
                return new Citadel(towerName, position);
        }
    }

    public static void ActivateTower(Tower t) { t.Activate(); }
    public static void InactivateTower(Tower t) { t.Inactivate(); }

    public static void setStats(Tower t, Double stat, String statType) throws exception {
        if (statType.equals("BuildCost")) {
            t.setBuildCost(stat);
        }
        else if (statType.equals("Damage")) {
            t.setDamage(stat);
        }
        else if (statType.equals("Defense")) {
            t.setDefense(stat);
        }
        else if (statType.equals("Damage")) {
            t.setDamage(stat);
        }
        else if (statType.equals("FireRate")) {
            t.setFireRate(stat);
        }
        else if (statType.equals("HealthPoint")) {
            t.setHealthPoint(stat);
        }
        else {
            throw new RuntimeException("Invalid stat type");
        }
    }
    public static void setAttackRange(Tower t, Coordinate ul, Coordinate lr) {
        Range r = new Range(ul, lr);
        t.setAttackRange(r);
    }
    public static void resetName(Tower t, String newName) {
        t.setName(newName);
    }
    public static void resetPosition(Tower t, Coordinate ul, Coordinate lr) {
        Range r = new Range(ul, lr);
        t.set(r);
    }

    public static void computeHpLost(Tower t, Double monsterDamage) {
        Double actualDamage = monsterDamage / ( 1 + (t.getDefense())/100 );
        t.setHealthPoint(t.getHealthPoint()-actualDamage);
        if ( t.getHealthPoint == 0 ) {
            t.Inactivate();
        }
    }
        
    }
}
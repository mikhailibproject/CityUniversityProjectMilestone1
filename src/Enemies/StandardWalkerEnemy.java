package Enemies;
import SkinsClasses.*;
import city.cs.engine.Walker;
import city.cs.engine.World;

public class StandardWalkerEnemy extends Enemy {
    public float walkSpeed = 3;
    public float walkingDirection = 1; // 1 walking right, -1 walking left

    //BasicHealth and damage
    public StandardWalkerEnemy(String SkinName, World w, EnemySpawner NewSpawner) {
        super(w, Skin.skinCollection.get(SkinName).GetShape(), NewSpawner);
        this.skin = Skin.skinCollection.get(SkinName);
        this.addImage(this.skin.getOrientationBasic());
    }

    // Custom Health and damage
    public StandardWalkerEnemy(String SkinName, World w, EnemySpawner NewSpawner,
                               int Health, int Damage, float walkSpeed) {
        super(w, Skin.skinCollection.get(SkinName).GetShape(), NewSpawner, Health, Damage);
        this.skin = Skin.skinCollection.get(SkinName);
        this.walkSpeed = walkSpeed;
    }
}

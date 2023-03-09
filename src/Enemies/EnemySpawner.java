package Enemies;

import SkinsClasses.Skin;
import city.cs.engine.*;
import city.cs.engine.Shape;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class EnemySpawner extends StaticBody {
    private Skin skin = Skin.skinCollection.get("PortalSkin");
    private Queue<Enemy> enemies = new LinkedList<>();
    public EnemySpawner(World w) {
        super(w);
        this.addImage(this.skin.getOrientationBasic());
    }
    public void AddEnemyToSpawner(Enemy e){
        enemies.add(e);
    }
    public void SpawnEnemy() {
        if(!this.enemies.isEmpty()){
            this.enemies.poll().setPosition(this.getPosition());
        } else {
            this.destroy();
        }
    }
}

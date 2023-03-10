import Enemies.EnemySpawner;
import Enemies.StandardWalkerEnemy;
import Surroundings.MovingPlatform;
import Surroundings.Platform;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.List;

public class GamePlayground extends World {

    private Vec2 PlayerSpawnPosition = new Vec2(0,0);
    public GamePlayground(){
        // Creation of level borders -- Begins
        Platform ground = new Platform(this, new BoxShape(100,10));
        ground.setPosition(new Vec2(0,-24));

        Platform top = new Platform(this, new BoxShape(100,10));
        top.setPosition(new Vec2(0,24));

        Platform RightSide = new Platform(this, new BoxShape(10,100));
        RightSide.setPosition(new Vec2(29, 0));

        Platform LeftSide = new Platform(this, new BoxShape(10,100));
        LeftSide.setPosition(new Vec2(-29, 0));

        // level is an abstract height
        BoxShape standardPlatform = new BoxShape(7, 0.5f);
        // Creation of level-1 platforms
        Platform L1RightSide = new Platform(this, standardPlatform);
        L1RightSide.setPosition(new Vec2(12, -5));

        Platform L1LeftSide = new Platform(this, standardPlatform);
        L1LeftSide.setPosition(new Vec2(-12, -5));

        // Creation of level-2 platforms
        MovingPlatform L2Center = new MovingPlatform(this, standardPlatform, true, 10, 10);
        L2Center.setPosition(new Vec2(0, 5));

        // Creation of enemy Spawner Level 1
        EnemySpawner L1Spawner = new EnemySpawner(this);
        L1Spawner.setPosition(new Vec2(-15, -10));
        L1Spawner.AddEnemyToSpawner(new StandardWalkerEnemy("StandardEnemySkin", this, L1Spawner));
        L1Spawner.AddEnemyToSpawner(new StandardWalkerEnemy("StandardEnemySkin", this, L1Spawner));
        L1Spawner.SpawnEnemy();
        EnemySpawner L1Spawner2 = new EnemySpawner(this);
        L1Spawner2.setPosition(new Vec2(15, -10));
        L1Spawner2.AddEnemyToSpawner(new StandardWalkerEnemy("StandardEnemySkin", this, L1Spawner,
                5, 2, 5));
        L1Spawner2.SpawnEnemy();

    }

    public Vec2 getPlayerSpawnPosition(){
        return this.PlayerSpawnPosition;
    }
}

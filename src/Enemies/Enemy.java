package Enemies;
import SkinsClasses.Skin;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public  abstract class Enemy extends Walker {
    private int health = 1;
    private int damage = 1;
    private final EnemySpawner spawner; // link to the place where enemies can be spawned
    protected Skin skin;

    // Use of basic health and damage stats
    public Enemy(World w, Shape s, EnemySpawner NewSpawner) {
        super(w, s);
        this.spawner = NewSpawner;
        this.setPosition(new Vec2(-1000,-1000));
    }

    // Custom Health and damage stats
    public Enemy(World w, Shape s, EnemySpawner NewSpawner, int Health, int Damage) {
        super(w, s);
        this.spawner = NewSpawner;
        this.health = Health;
        this.damage = Damage;
        this.setPosition(new Vec2(-1000,-1000));
    }

    public int GetHealth() {
        return this.health;
    }

    public int GetDamage() {
        return this.damage;
    }

    public void decreaseHealth(int amount){
        this.health = this.health - amount;
        if(this.health <= 0){
            this.destroy();
        }
    }
}

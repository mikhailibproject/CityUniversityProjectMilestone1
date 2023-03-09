import SkinsClasses.Skin;
import city.cs.engine.*;

public class Player extends Walker {
    public int health;
    public int level;
    public static int coinsLeft = 0;
    public Skin skin;
    public final float jumHeight = 20;
    public final float walkSpeed = 7;
    public final float Gravity = 2;

    Player(String SkinName, int Health, int Level, World world) {
        super(world, Skin.skinCollection.get(SkinName).GetShape());
        this.skin = Skin.skinCollection.get(SkinName);
        this.health = Health;
        this.level = Level;
        addImage(skin.getOrientationBasic());
        setGravityScale(this.Gravity);
    }

}


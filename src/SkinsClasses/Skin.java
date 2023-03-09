package SkinsClasses;
import city.cs.engine.*;
import java.util.HashMap;

public class Skin {
    public static HashMap<String, Skin> skinCollection = new HashMap<String, Skin>();
    private String name;
    private float baseHeight;
    private Shape skinShape;
    private boolean hasShape = false;
    public BodyImage OrientationBasic; // speed = 0
    public BodyImage OrientationRight; // positive speed
    public BodyImage OrientationLeft; // negative speed

    public Skin(String name, float baseHeight, String BaseImageLink){
        this.name = name;
        this.baseHeight = baseHeight;
        this.OrientationBasic = new BodyImage(BaseImageLink, baseHeight);
        this.OrientationRight = this.OrientationBasic;;
        this.OrientationLeft = this.OrientationBasic;

    }
    public Skin(String name, float baseHeight, String BaseImageLink, String RightImageLink,
                String LeftImageLink){
        this.name = name;
        this.baseHeight = baseHeight;
        this.OrientationBasic = new BodyImage(BaseImageLink, baseHeight);
        this.OrientationRight = new BodyImage(RightImageLink, baseHeight);
        this.OrientationLeft = new BodyImage(LeftImageLink, baseHeight);
    }


    public String getName() {
        return this.name;
    }

    public float getHeight() {
        return this.baseHeight;
    }

    public BodyImage getOrientationBasic(){
        return this.OrientationBasic;
    }

    public BodyImage getOrientationRight(){
        return this.OrientationRight;
    }
    public BodyImage getOrientationLeft(){
        return this.OrientationLeft;
    }

    public Shape GetShape(){
        return this.skinShape;
    }
    public void SetShape(Shape shape){
        this.skinShape = shape;
        this.hasShape = true;
    }

    public static void DownloadSkins(){
        // playerSkin
        skinCollection.put("StandardPlayerSkin",
                new Skin("StandardPlayerSkin",
                        5,
                        "Sprites/Rabbit.png",
                        "Sprites/RabbitWalkingRight.png",
                        "Sprites/RabbitWalkinLeft.png"));
        skinCollection.get("StandardPlayerSkin").SetShape(new BoxShape(0.8f, 2));

        skinCollection.put("StandardEnemySkin",
                new Skin("StandardEnemySkin",
                        5,
                        "Sprites/EnemyBasic.png",
                        "Sprites/EnemyRight.png",
                        "Sprites/EnemyLeft.png"));
        skinCollection.get("StandardEnemySkin").SetShape(new BoxShape(0.8f, 2));

        skinCollection.put("PortalSkin",
                new Skin("PortalSkin", 5,
                        "Sprites/Portal.png"));
    }

}

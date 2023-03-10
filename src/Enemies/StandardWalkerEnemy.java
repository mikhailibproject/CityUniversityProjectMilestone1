package Enemies;
import SkinsClasses.*;
import city.cs.engine.*;

import java.lang.annotation.Target;

public class StandardWalkerEnemy extends Enemy implements StepListener {
    public float walkSpeed = 3;
    private Sensor vision;
    private EnemyVisionListener visionListener;

    //BasicHealth and damage
    public StandardWalkerEnemy(String SkinName, World w, EnemySpawner NewSpawner) {
        super(w, Skin.skinCollection.get(SkinName).GetShape(), NewSpawner);
        this.skin = Skin.skinCollection.get(SkinName);
        this.addImage(this.skin.getOrientationBasic());
        visionSetUP();
        w.addStepListener(this);
    }

    // Custom Health and damage
    public StandardWalkerEnemy(String SkinName, World w, EnemySpawner NewSpawner,
                               int Health, int Damage, float walkSpeed) {
        super(w, Skin.skinCollection.get(SkinName).GetShape(), NewSpawner, Health, Damage);
        this.skin = Skin.skinCollection.get(SkinName);
        this.walkSpeed = walkSpeed;
        visionSetUP();
        w.addStepListener(this);
    }
    private void visionSetUP(){
        this.vision = new Sensor(this, new BoxShape(20, this.skin.getHeight()));
        this.visionListener = new EnemyVisionListener(this);
        this.vision.addSensorListener(visionListener);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if(this.targetIsSet){
            if(this.getPosition().x < this.target.getPosition().x){
                this.startWalking(walkSpeed);
                this.removeAllImages();
                this.addImage(this.skin.getOrientationRight());
            } else {
                this.startWalking(walkSpeed*-1);
                this.removeAllImages();
                this.addImage(this.skin.getOrientationLeft());
            }
        } else {
            this.stopWalking();
            this.removeAllImages();
            this.addImage(this.skin.getOrientationBasic());
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

}

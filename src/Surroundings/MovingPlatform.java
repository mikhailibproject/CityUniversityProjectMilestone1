package Surroundings;

import Surroundings.Platform;
import city.cs.engine.Shape;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class MovingPlatform extends Platform implements StepListener {
    //private Vec2 startPosition;
    private boolean isMovingHorizontally = true;
    private float barrier1, barrier2; // barrier1 - left/bottom barrier2 - right/top
    private float B1, B2; // amplitudes
    private float delta = 0.08f;

    public MovingPlatform(World w, Shape s, boolean IsMovingHorizontally, float B1, float B2) {
        super(w, s);
        this.isMovingHorizontally = IsMovingHorizontally;
        //B1 and B2 are amplitudes
        this.B1 = B1;
        this.B2 = B2;
        w.addStepListener(this);
    }

    public void setPosition(Vec2 position, boolean byUser) {
        this.setPosition(position);
        if(byUser){
            if(this.isMovingHorizontally){
                this.barrier1 = position.x - B1;
                this.barrier2 =  position.x + B2;
            } else {
                this.barrier1 = position.y - B1;
                this.barrier2 =  position.y + B2;
            }
        }
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        if(this.isMovingHorizontally){
            if(this.getPosition().x < barrier1){
                this.delta*=-1;
            }
            if(this.getPosition().x > barrier2){
                this.delta*=-1;
            }
            //this.setPosition(new Vec2(this.getPosition().x+delta, this.getPosition().y));
            this.move(new Vec2(delta, 0));
        } else {
            if(this.getPosition().y < barrier1){
                this.delta*=-1;
            }
            if(this.getPosition().y > barrier2){
                this.delta*=-1;
            }
            this.move(new Vec2(0, delta));
        }


    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}

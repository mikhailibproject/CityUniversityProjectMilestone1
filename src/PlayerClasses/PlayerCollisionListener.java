package PlayerClasses;

import Enemies.Enemy;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlayerCollisionListener implements CollisionListener {
    private Player p;

    public PlayerCollisionListener(Player p){
        this.p = p;
    }
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Enemy){
            p.health = p.health - ((Enemy) e.getOtherBody()).GetDamage();
        }
    }
}

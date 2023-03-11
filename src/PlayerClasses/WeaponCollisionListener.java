package PlayerClasses;

import Enemies.Enemy;
import Enemies.EnemyVisionListener;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class WeaponCollisionListener implements CollisionListener  {
    private Weapon w;
    WeaponCollisionListener(Weapon weapon){
        this.w = weapon;
    }

    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Enemy){
            ((Enemy) e.getOtherBody()).decreaseHealth(w.damage);
        }
    }
}

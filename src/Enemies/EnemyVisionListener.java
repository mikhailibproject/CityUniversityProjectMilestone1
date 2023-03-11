package Enemies;
import PlayerClasses.Player;
import city.cs.engine.*;
public class EnemyVisionListener implements SensorListener{
    private Enemy instance;

    EnemyVisionListener(Enemy Instance) {
        this.instance = Instance;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        System.out.println("Contacted with" + sensorEvent.getContactBody().getClass());
        if(sensorEvent.getContactBody() instanceof Player){
            System.out.println("New Target of type" + sensorEvent.getContactBody().getClass());
            instance.setTarget(sensorEvent.getContactBody());
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {
        System.out.println("No more contacted with " +  sensorEvent.getContactBody().getClass());
        if(sensorEvent.getContactBody() instanceof Player){
            instance.deleteTarget();
            System.out.println("Target was deleted");
        }
    }
}
